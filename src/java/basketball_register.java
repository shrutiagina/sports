/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KHSCI5MCA16059
 */
public class basketball_register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             HttpSession session = request.getSession();
           String name = (String)session.getAttribute("name");
           String age = (String)session.getAttribute("age");
           String gender = (String)session.getAttribute("gender");
           String usercategory = (String)session.getAttribute("usercategory");
          
           String mail = (String)session.getAttribute("mail");
           int cont = (int)session.getAttribute("cont");
           String address = (String)session.getAttribute("address");
           String pass = (String)session.getAttribute("pass");
           
                  String date = request.getParameter("date");
                  String time = request.getParameter("time");
                  String need = request.getParameter("need"); 
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet basketball_register</title>");            
            out.println("</head>");
            out.println("<body>");
          try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","");
                 
                      PreparedStatement ps =con.prepareStatement("select * from basketball");
                     out.println(date +"<br>");
                ResultSet rs = ps.executeQuery();
                 out.println(date+"<br>");
               while(rs.next())
               {
                   
                    
                     if(date.equals(rs.getString(10))&& time.equals(rs.getString(11)))
                     {
                           out.println(date+"<br>");
               
                         
                         MyGlobals.mail = rs.getString(6);
                         MyGlobals.date = rs.getString(10);
                         MyGlobals.hour = rs.getString(11);
                   
                  out.println("<html><body><script>alert('Date and Time has already fixed by other user!!!');window.location.assign('basketball_register.html');</script></body></html>");
                        
                     }
                     else
                     {
                  
                         PreparedStatement ps1 =con.prepareStatement("insert into basketball values(?,?,?,?,?,?,?,?,?,?,?)");
                         ps1.setString(1,name);
                         ps1.setString(2,age);
                         ps1.setString(3,gender);
                         ps1.setString(4,usercategory);
                       
                         ps1.setString(5,mail);
                         ps1.setInt(6,cont);
                         ps1.setString(7,address);
                         ps1.setString(8,pass);
                         ps1.setString(9,need);
                         ps1.setString(10,date);
                         ps1.setString(11,time);
            
                         ps1.executeUpdate();
                           //request.getRequestDispatcher("cricketServlet").forward(request, response);
                     }
                }
                  con.close();
               
                 
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

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
public class registerservlet extends HttpServlet {

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
           /* String name = request.getParameter("name");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            String usercategory = request.getParameter("usercategory");
            String sports = request.getParameter("sports");
            String mail = request.getParameter("mail");
            String contact = request.getParameter("contact");
            int cont = Integer.parseInt(contact);
            String address = request.getParameter("address");
            String pass = request.getParameter("pass");
            */
           
           HttpSession session = request.getSession();
           String name = (String)session.getAttribute("name");
           String age = (String)session.getAttribute("age");
           String gender = (String)session.getAttribute("gender");
           String usercategory = (String)session.getAttribute("usercategory");
           String sports = (String)session.getAttribute("sports");
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
            out.println("<title>Servlet registerservlet</title>");            
            out.println("</head>");
            out.println("<body>");
 
           
         
            
            
              try
              {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","");
                 
                      PreparedStatement ps =con.prepareStatement("select * from learners");
                     out.println(date +"<br>");
                ResultSet rs = ps.executeQuery();
                 out.println(date+"<br>");
               while(rs.next())
               {
                   
                    
                 
                     if(!date.equals(rs.getString(11)) && !time.equals(rs.getString(12))||(!date.equals(rs.getString(11))&&time.equals(rs.getString(12)))||(date.equals(rs.getString(11))&&!time.equals(12)))
                     {
                         
                         PreparedStatement ps1 = con.prepareStatement("insert into learners value(?,?,?,?,?,?,?,?,?,?,?,?)");
                         ps1.setString(1,name);
                         ps1.setString(2,age);
                         ps1.setString(3,gender);
                         ps1.setString(4,usercategory);
                         ps1.setString(5,sports);
                         ps1.setString(6,mail);
                         ps1.setInt(7,cont);
                         ps1.setString(8,address);
                         ps1.setString(9,pass);
                         ps1.setString(10,need);
                         ps1.setString(11,date);
                         ps1.setString(12,time);
            
                         ps1.executeUpdate();
                         
                         
                         
                         
                     }
                     else
                     {
                         out.println(date+"<br>");
               
                         
                         MyGlobals.mail = rs.getString(6);
                         MyGlobals.date = rs.getString(11);
                         MyGlobals.hour = rs.getString(12);
                   
                       out.println("<script type=\"text/javascript\">\n" +
"                     alert(\"Date and Time has already fixed for some other event!!! \");\n" +
"                     window.location.assign(\"registerpage.html\")\n" +
"                    </script>\n");
                       
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

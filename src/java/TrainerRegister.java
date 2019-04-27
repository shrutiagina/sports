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

/**
 *
 * @author KHSCI5MCA16059
 */
public class TrainerRegister extends HttpServlet {

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
            
            String name = request.getParameter("name");
            
            String ag = request.getParameter("age");
            
            int agee = Integer.parseInt(ag);
            
            String gender = request.getParameter("gender");
            
            String sports = request.getParameter("sports");
            
            String yoe = request.getParameter("years");
            
            int year = Integer.parseInt(yoe);
            
            String mail = request.getParameter("mail");
            
            String cont = request.getParameter("contact");
            
            int contct = Integer.parseInt(cont);
            
            String pass = request.getParameter("pass");
            
            String address = request.getParameter("address");
            
           
            
          
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TrainerRegister</title>");            
            out.println("</head>");
            out.println("<body>");
             try
              {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","");
                PreparedStatement ps1   =  con.prepareStatement("insert into trainers values(?,?,?,?,?,?,?,?,?)");
                
                
               
                         ps1.setString(1,name);
                         ps1.setInt(2,agee);
                         ps1.setString(3,gender);
                        
                         ps1.setString(4,sports);
                         ps1.setInt (5,year);
                         ps1.setString(6,mail);
                          ps1.setString(7,pass);
                         ps1.setInt(8,contct);
                         ps1.setString(9,address);
                        
                         
                         ps1.executeUpdate();
                out.println("<html><body><script>alert('ThankYou..You are registered with the club');window.location.assign('details.html');</script></body></html>");
                con.close();
              }
              catch(Exception e)
              {
                  out.println("Exception : "+e);
              }
            
          out.println("hello");
            
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

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
          
           
           
           String name = request.getParameter("name");
          String ag = request.getParameter("age");
           int age = Integer.parseInt(ag);
           String gender = request.getParameter("gender");
           String usercategory = request.getParameter("usercategory");
      
           String mail = request.getParameter("mail");
          
           double contact = Double.valueOf( request.getParameter("contact"));
           String address = request.getParameter("address");
           String pass = request.getParameter("pass");
          
          
           
          
            
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
                 PreparedStatement ps = con.prepareStatement("insert into user_register values(?,?,?,?,?,?,?,?)");
                 ps.setString(1, usercategory);
                 ps.setString(2, name);
                 ps.setInt(3, age);
                 ps.setString(4, gender);
                 ps.setString(5, mail);
                 ps.setDouble(6, contact);
                 ps.setString(7, address);
                 ps.setString(8, pass);
                 
                 ps.executeUpdate();
                    
               
               
               
              
               
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

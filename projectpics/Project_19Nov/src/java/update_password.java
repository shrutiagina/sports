/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author KHSCI5MCA16116
 */
public class update_password extends HttpServlet {

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
                 String current = request.getParameter("current");
            String newone = request.getParameter("newone");
           
            String id = request.getParameter("studid");
            String password="";
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_password</title>");            
            out.println("</head>");
            out.println("<body>");
             try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Result","root","");
                PreparedStatement ps = con.prepareStatement("select * from stud_create where REGISTER_NO = ?");
                ps.setString(1, id);
             
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    password = rs.getString(8);
                    
                }
                
                if(password.equals(current))
                {
                    PreparedStatement ps1 = con.prepareStatement("update stud_create set password = ? where REGISTER_NO=?");
                    
                    ps1.setString(1,newone);
                    ps1.setString(2, id);
                    ps1.executeUpdate();
                    out.println("password changed");
                }
                else
                {
                     out.println("<html><head></head><body onload=\"alert('check password')\"></body></html>");
                }
                con.close();
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            
      
            out.println("<h1>Servlet update_password at " + request.getContextPath() + "</h1>");
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

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
public class check_stud extends HttpServlet {

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
             String mail = request.getParameter("mail");
            String password = request.getParameter("pass");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet check_stud</title>");            
            out.println("</head>");
            out.println("<body>");
             try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Result","root","");
                PreparedStatement ps =con.prepareStatement("select * from stud_create");
                ResultSet rs = ps.executeQuery();
               while(rs.next())
               {
                     if(mail.equals(rs.getString(3))&& password.equals(rs.getString(8)))
                     {
                         
               
                         MyGlobals.stname = rs.getString(2);
                         response.sendRedirect("test.html");
                       
                        
                     }
                     else
                     {
                   //out.println("<html><head></head><body onload=\"alert('Kindly use a valid E-mail ID!')\"></body></html>");
                         out.println("<script type=\"text/javascript\">\n" +
"                     alert(\"Kindly enter valid mail id or password!  \");\n" +
"                     window.location.assign(\"link.html\")\n" +
"                    </script>\n");
                     }
                }
               
                
                con.close();
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            
            
            
            
            
            
            
            out.println("<h1>Servlet check_stud at " + request.getContextPath() + "</h1>");
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

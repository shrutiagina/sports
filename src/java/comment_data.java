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
public class comment_data extends HttpServlet {

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
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet comment_data</title>");            
            out.println("</head>");
            out.println("<body style= 'background-color:#CEF6F5;'>");
           try
           {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","");
                PreparedStatement ps = con.prepareStatement("select * from comment");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>Comments & Suggestions <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>NAME </th>"
                        + "<th>EMAIL</th>"
                       
                        
                        +"<th>MESSAGE</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    String name = rs.getString("Name");
                  
                    
                    String mail = rs.getString("email");
                   
                    String comments = rs.getString("comments");
                    
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+mail+"<td>  "+comments+" </tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                }
                 out.println("</table>");
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

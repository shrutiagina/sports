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
public class stud_result extends HttpServlet {

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
            out.println("<title>Servlet stud_result</title>");            
            out.println("</head>");
            out.println("<body style ='background-color:#85e0e0;'>");
                try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Result","root","");
                PreparedStatement ps = con.prepareStatement("select * from stud_create");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>Details of Student<h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>REGISTER_NO </th>"
                        + "<th>NAME</th>"
                        +"<th>EMAIL</th>"
                        +"<th>prev_science_marks</th>"
                        +"<th>prev_maths_marks</th>"
                        +"<th>prev_computer_marks</th>"
                        +"<th>prev_gk_marks</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    String regno = rs.getString("REGISTER_NO");
                    String name = rs.getString("NAME");
                    String email = rs.getString("EMAIL");
                    String science = rs.getString("prev_science_marks");
                    String maths = rs.getString("prev_maths_marks");
                    String computer = rs.getString("prev_computer_marks");
                    String gk = rs.getString("prev_gk_marks");
                    
                    int sci_marks = Integer.parseInt(science);
                    int math_marks = Integer.parseInt(maths);
                    int comp_marks = Integer.parseInt(computer);
                    int gk_marks = Integer.parseInt(gk);
                    
                    out.println("<tr align=center >"+ "<td >" +regno+"<td width ='20%' >"+name+"<td > "+email+"<td > "+ sci_marks +" <td > "+math_marks+" <td> "+comp_marks+"<td >  "+gk_marks+"</tr>");
                   
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
            out.println("<br><br>");
          out.println("<html><body><center><form action = 'result.html' method=POST><button type='submit' name='b1'>submit</button></form></center></body></html>");
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

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
public class StudentDetails extends HttpServlet {

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
            out.println("<title>Servlet StudentDetails</title>");            
            out.println("</head>");
            out.println("<body>");
           try
           {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sports","root","");
                PreparedStatement ps = con.prepareStatement("select * from learners where  USER_CATEGORY = 'Student'");
               
                   out.println("<center>");
                 out.println("<h2>STUDENT DETAILS </h2>");
               
                out.println("</center>"); 
              
                out.println("<table border=1  align=center>"
                        + "<tr>"
                        + "<th>NAME </th>"
                        + "<th>AGE</th>"
                        +"<th>GENDER</th>"
                        +"<th>USER_CATEGORY</th>"
                        +"<th>SPORTS</th>"
                        +"<th>EMAIL</th>"
                        +"<th>CONTACT NO.</th>"
                       
                        +"<th>ADDRESS</th>"
                        +"<th>NEED TRAINER?.</th>"
                        +"<th>DATE</th>"
                        +"<th>TIME</th>"
                        + "</tr>");
                
                  ResultSet rs = ps.executeQuery();
                 
                  while(rs.next())
                {
                    String name = rs.getString("NAME");
                    int ag = rs.getInt("AGE");
                    String gender = rs.getString("GENDER");
                    
                   String user = rs.getString("USER_CATEGORY");
                   String sports = rs.getString("SPORTS");
                   
                    String mail = rs.getString("EMAIL");
                    int cont = rs.getInt("CONTACT");
                  
                    String address = rs.getString("ADDRESS");
                    String need = rs.getString("NEED_TRAINER");
                   String Date = rs.getString("DATE");
                   String Time = rs.getString("TIME");
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+ag+"<td > "+gender+"<td >"+sports+"<td>"+mail+"<td >  "+cont+"  <td> "+address+"<td> "+need+" <td> "+Date+" <td> "+Time+" </tr>");
                   
                
                   
                    
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

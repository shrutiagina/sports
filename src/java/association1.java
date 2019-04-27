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
public class association1 extends HttpServlet {

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
            out.println("<title>Servlet association1</title>");            
            out.println("</head>");
            out.println("<body>");
                HttpSession session = request.getSession();
           String mail = (String)session.getAttribute("email");
         String name = "";
         String date ="";
         String sports ="";
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body background='usersev.jpg'> ");
            out.println("<br><h1 style='font-family:Mongolian Baiti;color:#088A85;'>WELCOME  TO  SR CLUB </h1>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Sports","root","");
               
                
                
                PreparedStatement ps = con.prepareStatement("select NAME ,DATE ,TIME,SPORTS from users where EMAIL =? ");
                mail = MyGlobals.mail ;
                ps.setString(1,mail);
              
                
               mail = MyGlobals.mail ;
               out.println("<h3 style='padding-left:75%'><br><br><br><br><br><br>EMAIL-ID :<br><u> "+mail+"</u></h3>");
               
                out.println("<br>");
                 out.println("<br>");
                  out.println("<br>");
                  
               ResultSet rs = ps.executeQuery();
                
               while(rs.next())
               {
                      name = rs.getString("NAME");
                      date = rs.getString("date");
                      
                      String time = rs.getString("time");
                      sports = rs.getString("SPORTS");
                      out.println("<div style=margin-left:70px;margin-right:200px>");

                      out.println("<br>");
                      out.println("<table border='1' width='40%' height='40%' cellspacing='30px' cellpadding='5px'>");
                      out.println("<tr align=center >"+ "<td >NAME <td >" +name+ "</tr>"
                         +"<tr align = 'center'>"+"<td width ='20%' >SPORTS<td>"+sports+"</tr>"+"<tr align='center'>"+"<td >DATE<td> "+date+"</tr>"+"<tr align='center'>"+"<td >TIME<td> "+time+"  </tr>");
               
                      out.println("</table>");
               
                      out.println("<br><br>");
                      out.println("<html><body><form method='POST' action = 'complaint'>"+"Complaints  : <br><br> "+"<textarea name = 'complaint' rows = '9' cols = '80'></textarea>"+"<br><br>"+"<input type = 'submit' value='Register'>"+"</form></body></html>");
                      out.println("<form action='updateInfo'><input type='submit' name = 'update' value='change'></form>");
                      out.println("</div>");
               
               }
          
      
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author KHSCI5MCA16059
 */
public class login extends HttpServlet {

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
         String mail = request.getParameter("email");
         String name = "";
          session.setAttribute("mail", mail); 
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
               
                
                
                PreparedStatement ps = con.prepareStatement("select NAME  from user_register where EMAIL =? ");
           
                ps.setString(1,mail);
              
                
              // mail = MyGlobals.mail ;
              
               ResultSet rs = ps.executeQuery();
          while(rs.next())
          
          {
               name = rs.getString("NAME");
                out.println("<h3 style='padding-left:75%'><br><br><br><br><br><br>EMAIL-ID :<br><u> "+name+"</u></h3>");
              
               
               out.println("<div style=margin-left:70px;margin-right:200px>");

              out.println("<br>");
              out.println("<form action='register2' method='POST'>");
               out.println("<table border='1' width='40%' height='40%' cellspacing='30px' cellpadding='5px'>");
                 out.println("<tr align=center >"+ "<td >EMAIL <td ><input type='email' name ='email' >"+ "</tr>"
                         +"<tr align = 'center'>"+"<td width ='20%' >SPORTS<td>"+"<select name=\"sports\" id=\"sports\" required><option>- SELECT -</option>\n" +
"                        <option value=\"Cricket\" > CRICKET </option>\n" +
"                        <option value=\"Football\"> FOOTBALL </option>\n" +
"                        <option value=\"Swimming\"> SWIMMING </option>\n" +
"                        <option value=\"Basketball\"> BASKETBALL </option>\n" +
"                        <option value=\"Badminton\"> BADMINTON </option>\n" +
"                        <option value=\"Volleyball\"> VOLLEYBALL </option></select>"+"</tr>"+"<tr align='center'>"+"<td >DATE<td> "+"<input type='date' name ='dt' >"+"</tr>"+"<tr align='center'>"+"<td >TIME<td> "+"<select name=\"time\"><option >-SELECT-</option>\n" +
"          <option value=\"1-2\">1-2</option>\n" +
"           <option value=\"3-4\">3-4</option>\n" +
"            <option value=\"5-6\">5-6</option>\n" +
"             <option value=\"7-8\">7-8</option>\n" +
"             </select>"+"  </tr>"+"<tr align ='center'>"+"<td>Need TRAINER<td><input type='radio' value = 'yes' name='need'>Yes &nbsp;&nbsp;&nbsp;&nbsp;<input value='no' type='radio' name='need'>No"+"</tr>"+"<br>"+"<tr width='10%' height='10%' align='center' colspan='2' >"+"<td colspan='2'>"+"<input style='padding:5px 25px' type='submit' value='submit' >"
                        +"<span style = 'padding-left:25%'>" +"<input style='padding:5px 25px' type='reset' value='reset'  >" +"</tr>"+"<br>");
              
               
               out.println("</table>");
               
               
                
           

               out.println("</form>");
               
              
               
               out.println("<br><br>");
                   out.println("<html><body><form method='POST' action = 'complaint'>"+"Complaints  : <br><br> "+"<textarea name = 'complaint' rows = '9' cols = '80'></textarea>"+"<br><br>"+"<input type = 'submit' value='Register'>"
                          
                           +"</form></body></html>");
                   out.println("<br><br><br>");
                   
                   out.println("<a href='index.html'><button style='background-color:color:#0489B1;; color:white;height: 30px;width: 150px'>LOGOUT</button></a>");
               
         
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

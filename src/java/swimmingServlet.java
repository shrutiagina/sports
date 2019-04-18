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
public class swimmingServlet extends HttpServlet {

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
            
            String user = request.getParameter("name");
            String mail = request.getParameter("mail");
            String date = request.getParameter("date");
            String hour = request.getParameter("hour");
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>.button:hover \n" +
"       {\n" +
"            background-color:#088A85    ; /* Green */\n" +
"            border: none;\n" +
"             color: white;\n" +
"            padding: 12px 28px;\n" +
"            text-align: center;\n" +
"            text-decoration: none;\n" +
"            display: inline-block;\n" +
"            font-size: 18px;\n" +
"            margin: 4px 2px;\n" +
"            -webkit-transition-duration: 0.4s; /* Safari */\n" +
"            transition-duration: 0.4s;\n" +
"            cursor: pointer;\n" +
"            border-radius:30px;\n" +
"            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);\n" +
"        }        </style>");
            out.println("<title>Servlet swimmingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
           try
            {
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/Sports","root","");     
                
               
                //PreparedStatement ps = con.prepareStatement
            
               //ResultSet rs = ps.executeQuery();
               
               out.println("<br><br>");
               out.println("<h1 align='center' style='color:#088A85'>SWIMMING</h1>");
                out.println("<br><br>");
               
               
                
                MyGlobals.date = date;
               mail = MyGlobals.mail ;
                out.println("<h3 style='padding-left:80%'> USER : "+user+"</h3>");
                out.println("<h3 style='padding-left:80%'>EMAIL-ID : "+mail+"</h3>");
                MyGlobals.hour = hour;
               

                
             out.println("<span style = 'padding-left:11%'><img src='swimming.jpg' width='80%' height='10%'></span>");
                
                out.println("<br><br><br>");
              
                out.println("<form>"
                        +"<h3>"
                        +"<span style='padding-left:14%'>SELECT DATE&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:" 
                        +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + "<input type=\"date\" name=\"date\" min=\"2007-06-01\" max=\"2019-05-31\" size=\"100\" required></span>"
                        +"<br><br><br>"+"<span style='padding-left:13%'>&nbsp;&nbsp;&nbsp;CHOOSE TIME &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<select name=\"h\">\n" +
"             <option>-SELECT-</option> \n" +
"             <option>10:00 am - 1:00 pm</option> \n" +
"             <option>1:30 pm - 4:30 pm</option> \n" +
"             <option>5:00 pm - 8:00 pm</option> \n" +
"             <option>8:30 pm - 11:30 pm</option> \n" +
"             </select>"
                        +"<br><br><br>"
                        +"</h3>"
                        +"<span style='padding-left:13%'><input class='button' type='submit' value='submit'>&nbsp;&nbsp;&nbsp;&nbsp;"
                        +"<input type='reset' class='button' value='reset'></span>"
                +"</form>");
                
                
        }
        catch(Exception e)
        {
           out.println(e);
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

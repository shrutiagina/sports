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
public class loginServlet extends HttpServlet {

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
            String pass = request.getParameter("id");
            String mail_id = request.getParameter("email");
            
            int flag = 0, lpage = 0;
            String sport = "";
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","");
               
               //ResultSet rs =  ps.executeQuery();
              //while(rs.next())
                     //{
                           //if(pass.equalsIgnoreCase("ps.getString(1)"))

                               // }
                               
                               
               out.println("<h1>Name : " + name + "<br>Email id : " + mail_id + "<br>Password : " + pass + "</h2>");
                               
               if(name.equalsIgnoreCase("trainer"))
               {
                          PreparedStatement ps = con.prepareStatement("select * from trainers");
                ResultSet rs = ps.executeQuery();
              
                while(rs.next())
                {
                    out.println("<h3>" + rs.getString(6) + "<br>" + rs.getString(9) + "</h3");
                    
                    if(mail_id.equals(rs.getString(6)) && pass.equals(rs.getString(7)))
                    {
                        MyGlobals.mail = mail_id;
                        flag = 1;
                        break;
                    }
                }
               
                if(flag == 1)
                {
                   PreparedStatement ps1 = con.prepareStatement("select * from trainers where email=?");
                   ps1.setString(1, mail_id);
                   
                   ResultSet r1 = ps1.executeQuery();
                   
                   while(r1.next())
                   {
                       out.println(r1.getString(4));
                       sport = r1.getString(4);
                   }
               }
               
               else
               {
                   
               }
                     
               }
               else if(name.equalsIgnoreCase("admin"))
               {
                   if(mail_id.equals("admin123@gmail.com")&&pass.equals("admin01"))
                   {    
                         request.getRequestDispatcher("admin.html").forward(request,response);
                   }
                   else
                   {
                        out.println("<html><body><script>alert('kindly enter valid email id and password');window.location.assign('loginpage.html');</script></body></html>");
                   }
               }
               
               
               
               
               
               
               else
               {
                PreparedStatement ps = con.prepareStatement("select * from learners");
                ResultSet rs = ps.executeQuery();
              
                while(rs.next())
                {
                    out.println("<h3>" + rs.getString(6) + "<br>" + rs.getString(9) + "</h3");
                    
                    if(mail_id.equals(rs.getString(6)) && pass.equals(rs.getString(9)))
                    {
                        MyGlobals.mail = mail_id;
                        flag = 1;
                        break;
                    }
                    else
                    {
                      out.println("Kindly enter valid mail is or password");
                    }
                }
               
                if(flag == 1)
                {
                   PreparedStatement ps1 = con.prepareStatement("select * from learners where email=?");
                   ps1.setString(1, mail_id);
                   
                   ResultSet r1 = ps1.executeQuery();
                   
                   while(r1.next())
                   {
                       out.println(r1.getString(5));
                       sport = r1.getString(5);
                   }
               }
               
               else
               {
                   
               }
               
               
               
                    
            }
               
               
               
               con.close();
            }
            catch(Exception e)
            {
                   out.println("Exception : "+e);
            }
            
            if(sport.equalsIgnoreCase("cricket"))
            {
                out.println("Hello world..!!!");
                request.getRequestDispatcher("cricketServlet").forward(request, response);
                
            }
            else if(sport.equalsIgnoreCase("Football"))
            {
                request.getRequestDispatcher("list.html").forward(request, response);
            }
            else if(sport.equalsIgnoreCase("Swimming"))
            {
                request.getRequestDispatcher("swimmingServlet").forward(request, response);
            }
            else if(sport.equals("Basketball"))
            {
                request.getRequestDispatcher("basketballServlet").forward(request, response);
            }
            else if(sport.equals("Badminton"))
            {
                request.getRequestDispatcher("badmintonServlet").forward(request, response);
            }
            
            else if(sport.equals("Volleyball"))
            {
                request.getRequestDispatcher("volleyballServlet").forward(request, response);
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

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
public class register2 extends HttpServlet {

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

            String need = request.getParameter("need");
            String date = request.getParameter("dt");
            String time = request.getParameter("time");
            String sports = request.getParameter("sports");
            String email = request.getParameter("email");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet register2</title>");
            out.println("</head>");
            out.println("<body>");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports", "root", "");
                PreparedStatement ps1 = con.prepareStatement("select * from user_register2 where   date = ? and time=? and sports=? ");
                PreparedStatement ps2=con.prepareStatement("select * from user_register2 where   date = ? and time=? and email=?");
                ps1.setString(1, date);
                ps1.setString(2, time);
                ps1.setString(3, sports);
                ps2.setString(1, date);
                ps2.setString(2, time);
                ps2.setString(3,email);
                ResultSet rs = ps1.executeQuery(),r=ps2.executeQuery();
               
               

                if(!rs.next()&&!r.next()) {
                    PreparedStatement ps = con.prepareStatement("insert into user_register2 values(?,?,?,?,?)");
                   

                    ps.setString(1, email);
                    ps.setString(2, need);
                    ps.setString(3, sports);
                    ps.setString(4, date);
                    ps.setString(5, time);
                    out.println(need);

                    ps.executeUpdate();
                    
                       out.println("<html><body><script>alert('ThankYou..You are registered with the club');window.location.assign('index.html');</script></body></html>");
                }
                else
                {
                    out.println(" <script> alert(\" Error\");window.location.assign('loginpage.html');</script>");
                }

            con.close();

        } catch (Exception e) {
            out.println("Exception : e" + e);
        }

        out.println("<h1>Servlet register2 at " + request.getContextPath() + "</h1>");
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

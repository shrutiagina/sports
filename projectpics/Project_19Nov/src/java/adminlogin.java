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

/**
 *
 * @author KHSCI5MCA16116
 */
public class adminlogin extends HttpServlet {

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
              String username = request.getParameter("mail");
            String password = request.getParameter("pass");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminlogin</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
             if(username!=null && username.equals("admin01@gmail.com") )
              {
                if(password.equals("mpssf")||password.equals("SreeAgmi"))
                {
                    
                   response.sendRedirect("adminInterface.html");
                   
                }
                else
                {
                       //out.println("<html><head></head><body onload=\"alert('Kindly use a valid Password!')\"></body></html>");
                    out.println("<script type=\"text/javascript\">\n" +
"                     alert(\"Kindly enter valid password!  \");\n" +
"                     window.location.assign(\"adminlogin.html\")\n" +
"                    </script>\n");
                }
            }
            else
            {
               // out.println("<script language=javascript");
                //out.println("alert \'Use a valid E-mail ID!\'");
               // out.println("</script>");
               out.println("<script type=\"text/javascript\">\n" +
"                     alert(\"Kindly enter valid mail id  \");\n" +
"                     window.location.assign(\"adminlogin.html\");>\n" +
"                    </script>\n");
                //out.println("<html><head></head><body onload=\"alert('Kindly use a valid E-mail ID!')\"></body></html>");
                 //response.sendRedirect("adminlogin");
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

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
public class manswer extends HttpServlet {

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
            out.println("<title>Servlet manswer</title>");            
            out.println("</head>");
            out.println("<body>");
               String rm1 = request.getParameter("m1");
            String rm2 = request.getParameter("m2");
            String rm3 = request.getParameter("m3");
            String rm4 = request.getParameter("m4");
            String rm5 = request.getParameter("m5");
            
            int correct = 0;
            int wrong = 0;
            int atnd=0;
            int natnd=0;
             
             if(rm1==null)
            {
               wrong++;
               natnd++;
            }
             
             else if(rm1.equals("m14"))
             {
                 correct++;
                 atnd++;
             }
            else
            {
                 wrong++;
                  atnd++;
            }
              
             if(rm2==null)
             {
                 wrong++;
                 natnd++; 
             }
             
           else if(rm2.equals("m22"))
            {
                 correct++;
                  atnd++;
            }
           
            else
            {
                wrong++;
                 atnd++;
            }
            
             if(rm3==null)
             {
                 wrong++;
                  natnd++;
             }
             
             else if(rm3.equals("m34"))
            {
                correct++;
                 atnd++;
            }
            
            else
            {
                wrong++;
                 atnd++;
            }
             
             if(rm4==null)
             {
                 wrong++;
                  natnd++;
             }
          else  if(rm4.equals("m43"))
            {
                correct++;
                 atnd++;
            }
            
            else
            {
               wrong++;
                atnd++;
            }
               
             if(rm5==null)
             {
                 wrong++;
                  natnd++;
             }
         else   if(rm5.equals("m52")) 
            {
                correct++;   
                 atnd++;
                
            }
            
            else
            {
                 wrong++;
                 atnd++; 
            } 
           
              out.println("<center>"); 
              
              out.println("No.of total questions : 5 <br>" );
              out.println("No.of correct answers : "+correct+"<br>");  
            
              out.println("\n No.of wrong answers : "+wrong+"<br>");
               
                out.println("No.of attended questions : "+atnd+"<br><br><br>"); 
              
              out.println("TOTAL MARKS  : "+correct+"<br>");
              out.println("</center>");  
            
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Result","root","");
                PreparedStatement ps = con.prepareStatement("select * from stud_create where name = ?");
                ps.setString(1,MyGlobals.stname) ;
                
                ResultSet rs = ps.executeQuery();
                int current_marks = 0;
                while(rs.next())
                {
                    current_marks = rs.getInt(5);
                }
                
                out.println(current_marks+"\n");
                
                current_marks += correct;
                
                out.println(current_marks);
                
                PreparedStatement ps1 = con.prepareStatement("update stud_create set Prev_MATHS_Marks=? where NAME = ?");
                ps1.setInt(1,current_marks);
                ps1.setString(2,MyGlobals.stname);
                
                ps1.executeUpdate();
                con.close();
              
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            
          
            
            out.println("<h1>Servlet manswer at " + request.getContextPath() + "</h1>");
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

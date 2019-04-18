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
public class sanswer extends HttpServlet {

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
            out.println("<title>Servlet sanswer</title>");            
            out.println("</head>");
            out.println("<body>");
              String rs1 = request.getParameter("s1");
            String rs2 = request.getParameter("s2");
            String rs3 = request.getParameter("s3");
            String rs4 = request.getParameter("s4");
            String rs5 = request.getParameter("s5");
            String name ;
            String register ;
            String email ;
            
            int temp = 0;
            
            int correct = 0;
            int wrong = 0;
            int atnd=0;
            int natnd=0;
             
           
             if(rs1==null)
            {
               wrong++;
               natnd++;
            }
             
             else if(rs1.equals("s12"))
             {
                 correct++;
                 atnd++;
             }
            else
            {
                 wrong++;
                  atnd++;
            }
              
             if(rs2==null)
             {
                 wrong++;
                 natnd++; 
             }
             
           else if(rs2.equals("s22"))
            {
                 correct++;
                  atnd++;
            }
           
            else
            {
                wrong++;
                 atnd++;
            }
            
             if(rs3==null)
             {
                 wrong++;
                  natnd++;
             }
             
             else if(rs3.equals("s32"))
            {
                correct++;
                 atnd++;
            }
            
            else
            {
                wrong++;
                 atnd++;
            }
             
             if(rs4==null)
             {
                 wrong++;
                  natnd++;
             }
          else  if(rs4.equals("s41"))
            {
                correct++;
                 atnd++;
            }
            
            else
            {
               wrong++;
                atnd++;
            }
               
             if(rs5==null)
             {
                 wrong++;
                  natnd++;
             }
         else   if(rs5.equals("s54")) 
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
              out.println("temp"+(temp =correct));
              out.println("</center>");  
              try
              {
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Result","root","");
                  PreparedStatement ps = con.prepareStatement("select * from stud_create where name=?");
                  ps.setString(1, MyGlobals.stname);
                  ResultSet rs = ps.executeQuery();
                  
                  int current_marks = 0;
                  
                  while(rs.next())
                  {
                      current_marks = rs.getInt(4);
                  }
                  
                  out.println("<h1>" + current_marks + "</h1>");
                  
                  current_marks += correct;
                  
                  out.println("<h1>" + current_marks + "</h1>");
                  
                  PreparedStatement pst = con.prepareStatement("update stud_create set Prev_SCIENCE_MARKS=? where name=?");
                  pst.setInt(1, current_marks);
                  pst.setString(2, MyGlobals.stname);
                  
                  pst.executeUpdate();
                  
                  con.close();
              }
              catch(Exception e)
              {
                  out.println("Exception : "+e);
              }
                
            out.println("<h1>Servlet sanswer at " + request.getContextPath() + "</h1>");
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

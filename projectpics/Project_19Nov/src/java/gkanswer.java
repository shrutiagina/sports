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
public class gkanswer extends HttpServlet {

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
            out.println("<title>Servlet gkanswer</title>");            
            out.println("</head>");
            out.println("<body>");
                 String rg1 = request.getParameter("g1");
            String rg2 = request.getParameter("g2");
            String rg3 = request.getParameter("g3");
            String rg4 = request.getParameter("g4");
            String rg5 = request.getParameter("g5");
            
            int correct = 0;
            int wrong = 0;
            int atnd=0;
            int natnd=0;
            
            if(rg1==null)
            {
               wrong++;
               natnd++;
            }
             
             else if(rg1.equals("g13"))
             {
                 correct++;
                 atnd++;
             }
            else
            {
                 wrong++;
                  atnd++;
            }
              
             if(rg2==null)
             {
                 wrong++;
                 natnd++; 
             }
             
           else if(rg2.equals("g22"))
            {
                 correct++;
                  atnd++;
            }
           
            else
            {
                wrong++;
                 atnd++;
            }
            
             if(rg3==null)
             {
                 wrong++;
                  natnd++;
             }
             
             else if(rg3.equals("g33"))
            {
                correct++;
                 atnd++;
            }
            
            else
            {
                wrong++;
                 atnd++;
            }
             
             if(rg4==null)
             {
                 wrong++;
                  natnd++;
             }
          else  if(rg4.equals("g43"))
            {
                correct++;
                 atnd++;
            }
            
            else
            {
               wrong++;
                atnd++;
            }
               
             if(rg5==null)
             {
                 wrong++;
                  natnd++;
             }
         else   if(rg5.equals("g52")) 
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
                  PreparedStatement ps = con.prepareStatement("select * from stud_create where name =?");
                  ps.setString(1,MyGlobals.stname);
                  
                  ResultSet rs = ps.executeQuery();
                  
                  int current_marks = 0;
                  while(rs.next())
                  {
                      current_marks = rs.getInt(7);
                  }
                  out.println(current_marks+"\n");
                  
                  current_marks += correct;
                  
                  out.println(current_marks+"\n");
                  PreparedStatement pst = con.prepareStatement("update stud_create set Prev_GK_MARKS = ? where name = ?");
                  pst.setInt(1,current_marks);
                  pst.setString(2,MyGlobals.stname);
                  
                  pst.executeUpdate();
                  
                  con.close();
                 
                  
              }
              catch(Exception e)
              {
                  out.println("Exception : "+e);
              }
            
            
            
            
              
            
            out.println("<h1>Servlet gkanswer at " + request.getContextPath() + "</h1>");
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

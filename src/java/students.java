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
public class students extends HttpServlet {

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
           String  cricket = request.getParameter("cricket");
           String  football = request.getParameter("football");
           String  basketball = request.getParameter("basketball");
           String  badminton = request.getParameter("badminton");
           String  volleyball = request.getParameter("volleyball");
           String  swimming = request.getParameter("swimming");
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet students</title>");            
            out.println("</head>");
            out.println("<body style='background-color:#CEF6F5'>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports","root","");
               if(cricket!=null)
               {
                 PreparedStatement ps = con.prepareStatement("select * from cricket where USER_CATEGORY='Student'");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>STUDENT DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>NAME </th>"
                        + "<th>AGE</th>"
                        +"<th>GENDER</th>"
                        
                        
                        +"<th>EMAIL</th>"
                        +"<th>CONTACT NO.</th>"
                       
                        +"<th>ADDRESS</th>"
                        +"<th>NEED TRAINER?.</th>"
                        +"<th>DATE</th>"
                        +"<th>TIME</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    String name = rs.getString("NAME");
                    int ag = rs.getInt("AGE");
                    String gender = rs.getString("GENDER");
                    
                   
                    String mail = rs.getString("EMAIL");
                    int cont = rs.getInt("CONTACT");
                  
                    String address = rs.getString("ADDRESS");
                    String need = rs.getString("NEED_TRAINER");
                   String Date = rs.getString("DATE");
                   String Time = rs.getString("TIME");
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+ag+"<td > "+gender+"<td > "+mail+"<td >  "+cont+"  <td> "+address+"<td> "+need+" <td> "+Date+" <td> "+Time+" </tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                }
                 out.println("</table>");
               
               }
                
               
               
               
            
                 /*football*/
                 
                 
                    if(football!=null)
               {
                 PreparedStatement ps = con.prepareStatement("select * from football where USER_CATEGORY='Student'");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>STUDENT DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>NAME </th>"
                        + "<th>AGE</th>"
                        +"<th>GENDER</th>"
                        
                        
                        +"<th>EMAIL</th>"
                        +"<th>CONTACT NO.</th>"
                       
                        +"<th>ADDRESS</th>"
                        +"<th>NEED TRAINER?.</th>"
                        +"<th>DATE</th>"
                        +"<th>TIME</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    String name = rs.getString("NAME");
                    int ag = rs.getInt("AGE");
                    String gender = rs.getString("GENDER");
                    
                   
                    String mail = rs.getString("EMAIL");
                    int cont = rs.getInt("CONTACT");
                  
                    String address = rs.getString("ADDRESS");
                    String need = rs.getString("NEED_TRAINER");
                   String Date = rs.getString("DATE");
                   String Time = rs.getString("TIME");
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+ag+"<td > "+gender+"<td > "+mail+"<td >  "+cont+"  <td> "+address+"<td> "+need+" <td> "+Date+" <td> "+Time+" </tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                }
                 out.println("</table>");
               
               }
                    
                    
                    /*basketball*/
                    
                    
                       if(basketball!=null)
               {
                 PreparedStatement ps = con.prepareStatement("select * from basketball where USER_CATEGORY='Student'");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>STUDENT DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>NAME </th>"
                        + "<th>AGE</th>"
                        +"<th>GENDER</th>"
                        
                        
                        +"<th>EMAIL</th>"
                        +"<th>CONTACT NO.</th>"
                       
                        +"<th>ADDRESS</th>"
                        +"<th>NEED TRAINER?.</th>"
                        +"<th>DATE</th>"
                        +"<th>TIME</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    String name = rs.getString("NAME");
                    int ag = rs.getInt("AGE");
                    String gender = rs.getString("GENDER");
                    
                   
                    String mail = rs.getString("EMAIL");
                    int cont = rs.getInt("CONTACT");
                  
                    String address = rs.getString("ADDRESS");
                    String need = rs.getString("NEED_TRAINER");
                   String Date = rs.getString("DATE");
                   String Time = rs.getString("TIME");
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+ag+"<td > "+gender+"<td > "+mail+"<td >  "+cont+"  <td> "+address+"<td> "+need+" <td> "+Date+" <td> "+Time+" </tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                }
                 out.println("</table>");
               
               }
                
                
                       
                       /*volleyball*/
                       
                       
                       
                          if(volleyball!=null)
               {
                 PreparedStatement ps = con.prepareStatement("select * from volleyball where USER_CATEGORY='Student'");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>STUDENT DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>NAME </th>"
                        + "<th>AGE</th>"
                        +"<th>GENDER</th>"
                        
                        
                        +"<th>EMAIL</th>"
                        +"<th>CONTACT NO.</th>"
                       
                        +"<th>ADDRESS</th>"
                        +"<th>NEED TRAINER?.</th>"
                        +"<th>DATE</th>"
                        +"<th>TIME</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    String name = rs.getString("NAME");
                    int ag = rs.getInt("AGE");
                    String gender = rs.getString("GENDER");
                    
                   
                    String mail = rs.getString("EMAIL");
                    int cont = rs.getInt("CONTACT");
                  
                    String address = rs.getString("ADDRESS");
                    String need = rs.getString("NEED_TRAINER");
                   String Date = rs.getString("DATE");
                   String Time = rs.getString("TIME");
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+ag+"<td > "+gender+"<td > "+mail+"<td >  "+cont+"  <td> "+address+"<td> "+need+" <td> "+Date+" <td> "+Time+" </tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                }
                 out.println("</table>");
               
               }
                
                          
                          /*swimming*/
                          
                          
                             if(swimming!=null)
               {
                 PreparedStatement ps = con.prepareStatement("select * from swimming where USER_CATEGORY='Student'");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>STUDENT DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>NAME </th>"
                        + "<th>AGE</th>"
                        +"<th>GENDER</th>"
                        
                        
                        +"<th>EMAIL</th>"
                        +"<th>CONTACT NO.</th>"
                       
                        +"<th>ADDRESS</th>"
                        +"<th>NEED TRAINER?.</th>"
                        +"<th>DATE</th>"
                        +"<th>TIME</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    String name = rs.getString("NAME");
                    int ag = rs.getInt("AGE");
                    String gender = rs.getString("GENDER");
                    
                   
                    String mail = rs.getString("EMAIL");
                    int cont = rs.getInt("CONTACT");
                  
                    String address = rs.getString("ADDRESS");
                    String need = rs.getString("NEED_TRAINER");
                   String Date = rs.getString("DATE");
                   String Time = rs.getString("TIME");
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+ag+"<td > "+gender+"<td > "+mail+"<td >  "+cont+"  <td> "+address+"<td> "+need+" <td> "+Date+" <td> "+Time+" </tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                }
                 out.println("</table>");
               
               }
                
                 
                             /*badminton*/
                             
                             
                             
                                if(badminton!=null)
               {
                 PreparedStatement ps = con.prepareStatement("select * from badminton where USER_CATEGORY='Student'");
                ResultSet rs = ps.executeQuery();
                out.println("<center>");
                out.println("<h1>STUDENT DETAILS <h1>");
               
                out.println("</center>"); 
              
                out.println("<table border=1 width=60% height=80% align=center>"
                        + "<tr>"
                        + "<th>NAME </th>"
                        + "<th>AGE</th>"
                        +"<th>GENDER</th>"
                        
                        
                        +"<th>EMAIL</th>"
                        +"<th>CONTACT NO.</th>"
                       
                        +"<th>ADDRESS</th>"
                        +"<th>NEED TRAINER?.</th>"
                        +"<th>DATE</th>"
                        +"<th>TIME</th>"
                        + "</tr>");
              
                while(rs.next())
                {
                    String name = rs.getString("NAME");
                    int ag = rs.getInt("AGE");
                    String gender = rs.getString("GENDER");
                    
                   
                    String mail = rs.getString("EMAIL");
                    int cont = rs.getInt("CONTACT");
                  
                    String address = rs.getString("ADDRESS");
                    String need = rs.getString("NEED_TRAINER");
                   String Date = rs.getString("DATE");
                   String Time = rs.getString("TIME");
                    //int age = Integer.parseInt(ag);
                    //int years = Integer.parseInt(yoe);
                    //int contact = Integer.parseInt(cont);
                    
                    
                    out.println("<tr align=center >"+ "<td >" +name+"<td width ='20%' >"+ag+"<td > "+gender+"<td > "+mail+"<td >  "+cont+"  <td> "+address+"<td> "+need+" <td> "+Date+" <td> "+Time+" </tr>");
                   
                    out.println("<br>");
                   
                    out.println("<br>");
                    
                }
                 out.println("</table>");
               
               }
                
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

<%-- 
    Document   : NextPage
    Created on : Mar 29, 2019, 7:29:15 PM
    Author     : KHSCI5MCA16059
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><br><br>
        <h1 style="color:#399C8D"><center>SELECT  DAY  &  TIME</center></h1>
        <img style="margin-left:40px;margin-right:140px;" src="dc.jpg"  width="100%">
         
        <%
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String gender = request.getParameter("gender");
            String usercategory = request.getParameter("usercategory");
            String sports = request.getParameter("sports");
           
            String mail = request.getParameter("mail");
            String contact = request.getParameter("contact");
            int cont = Integer.parseInt(contact);
            String address = request.getParameter("address");
            String pass = request.getParameter("pass");
            String type = request.getParameter("type");

            session.setAttribute("name",name);
            session.setAttribute("age", age);
            session.setAttribute("gender", gender);
            session.setAttribute("usercategory", usercategory);
            session.setAttribute("sports", sports);
            session.setAttribute("mail", mail); 
            session.setAttribute("cont", cont);
            session.setAttribute("address", address);
            session.setAttribute("pass",pass);
            session.setAttribute("type",type);    
           
        %>
        
        <center>
        <div>
            <br><br><br><br>
      
      <form action="registerservlet" method="POST">
          <fieldset>
           <legend style="color:white;">REGISTRATION FORM</legend>
      Need Trainer &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="Yes" name="need">YES&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"  value="No" name="need">NO<br><br><br><br>
      Select Date &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" name="date"><br><br><br><br>
      Select Time &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="time"><option >-SELECT-</option>
          <option value="1-2">1-2</option>
           <option value="3-4">3-4</option>
            <option value="5-6">5-6</option>
             <option value="7-8">7-8</option>
             </select>
          <br><br><br><br>
     
      <input type="submit" name="submit" value="submit" >&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" name="reset">&nbsp;&nbsp;&nbsp;&nbsp;
          </fieldset>
      </form>
            <br><br><br><br>
            </div>
            </center>
        
        
    </body>
</html>

<%-- 
    Document   : success
    Created on : Nov 6, 2018, 6:22:23 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/bg2.jpg">
        <h3 style="color:Dark blue" align="center">You have successfully Login</h3>
    <center><a href="/SpringMVCHibernateCRUD/test"><font style="color:Dark blue" size="5">Add Skill</font></a><br></center>
 <center><a href="/SpringMVCHibernateCRUD/employeelist"><font style="color:Dark blue" size="5">Employee List</font></a></center>
   <tr>
   
</tr>

 <div align="right">
        <form action="logout" method="get">
        <input type="submit" value="Logout"> 
        </form></div>
        
          
</body>
</html>

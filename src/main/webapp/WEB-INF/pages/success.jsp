<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/bg2.jpg">
          <%@include file="header.jsp" %>
         
         
         <form commandName="employee">
    
       
       
        <h3 style="color:blue" align="center"> Welcome ${employee.name}</h3>
        <h3 style="color:Red" align="center"> You have successfully logged in!!!</h3>
    <center><a href="/PMS-1.0/test"><font style="color:Dark blue" size="5">Add Skill</font></a><br></center>
    <center><a href="/PMS-1.0/employeelist"><font style="color:Dark blue" size="5">Employee List</font></a></center>

</form>
    </body>

</html>

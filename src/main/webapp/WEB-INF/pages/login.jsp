<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login.</title>
    </head>
    <body style="background-image: url('http://deltatimes24.com/uploads/images/login-background-images-for-website-10.jpg'); ">

        <!--        <a href="/SpringMVCHibernateCRUD/employeelist">EmployeeList</a>-->
        <h1 style="color:white" align="center">Login</h1>
    <center>
        <form:form method="post" name="loginForm" >
            <table>
                <tr><td style="color:white">User Name: </td><td><input name="userName" type="textbox"></td></tr>
                <tr><td style="color:white">Password: </td><td><input name="password" type="password"></td></tr>
                <tr><td colspan="2" align="right"><input type="submit" value="LOGIN"></td></tr>
            </table>
            <div style="color:red">${error}</div>
        </form:form>
    </center> 
    <!--            <a href="/SpringMVCHibernateCRUD/test">Add Skill</a>-->
</body>
</html>

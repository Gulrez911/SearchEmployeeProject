<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login.</title>
    </head>
    <body>
        <img src="/resources/login.jpg" alt="Trulli" width="500" height="333">
        <!--        <a href="/SpringMVCHibernateCRUD/employeelist">EmployeeList</a>-->
        <h4>User Login.</h4>
    <center>
        <form:form method="post" name="loginForm" >
            <table>
                <tr><td>User Name: </td><td><input name="userName" type="textbox"></td></tr>
                <tr><td>Password: </td><td><input name="password" type="password"></td></tr>
                <tr><td colspan="2" align="right"><input type="submit" value="Submit"></td></tr>
            </table>
            <div style="color:red">${error}</div>
        </form:form>
    </center> 
    <!--            <a href="/SpringMVCHibernateCRUD/test">Add Skill</a>-->
</body>
</html>

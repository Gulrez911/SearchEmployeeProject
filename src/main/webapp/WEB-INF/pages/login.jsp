<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login.</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/india-wallpaper.jpg">

        <!--        <a href="/SpringMVCHibernateCRUD/employeelist">EmployeeList</a>-->
        <h1 style="color:white" align="center">Login</h1>

 
        <form:form action="authenticate" method="post" commandName="user" >
            <table align="center">
                <tr>
                		<td style="color:white">User Name: </td>
               		 <td><input name="userName" type="textbox"></td>
               </tr>
                <tr>
               		 <td style="color:white">Password: </td>
                	<td><input name="password" type="password"></td>
                </tr>
                <tr>
                 <td ><form:select path ="category" name="userTypes">
                    
                     <form:options items = "${userTypes}" />
                     
						</form:select>
						</td>
					
               <td colspan="2" align="right"><input type="submit" value="LOGIN"></td></tr>

            </table>
           			 <div style="color:red">${error}</div>
        </form:form>

    <!--            <a href="/SpringMVCHibernateCRUD/test">Add Skill</a>-->
</body>
</html>

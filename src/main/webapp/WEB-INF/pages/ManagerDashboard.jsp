<%-- 
    Document   : ManagerDashboard
    Created on : Dec 28, 2018, 5:28:29 PM
    Author     : user
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>

        <SCRIPT type="text/javascript">
            window.history.forward();
            function noBack() {
                window.history.forward();
            }
        </SCRIPT>

        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/pineapple.jpg">
    <div>
        <h4>Welcome to DashBoard</h4>
        <div align="center">
            <form:form action="/SpringMVCHibernateCRUD/Empedit" method="post"
                       modelAttribute="employee" commandName="employee">
                <form:hidden path="email" />
                <input type="submit" value="Edit Profile">
            </form:form>
            </br>
            <form:form action="/SpringMVCHibernateCRUD/createProject2" method="post"  modelAttribute="employee">
                <form:hidden path="email" />
                <input type="submit" value="Create Project">
            </form:form>
            </br>
            
            <form:form action="/SpringMVCHibernateCRUD/managerProjectView" method="post"  modelAttribute="employee">
                <form:hidden path="email" />
                <input type="submit" value="Project Status">
            </form:form>
          
        </div>
       
         </div>
    </body>
</html>

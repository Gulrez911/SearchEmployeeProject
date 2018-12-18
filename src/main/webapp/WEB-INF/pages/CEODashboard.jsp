<%-- 
    Document   : CEODashboard
    Created on : Dec 18, 2018, 10:55:29 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/wood.jpg">
        <h1>Hello World!</h1>
        <div align="center">
            <table border="1">
                <th>Project Name</th>
                <th>Delay</th>
                   <c:forEach var="pd" items="${listProject}">
                    <tr>
                        <td><a href="displayProjectDetails">${pd.project_Name}</td>
                        <td>

                        </td>
                    </tr>
                </c:forEach> 
            </table>
        </div>
    </body>
</html>

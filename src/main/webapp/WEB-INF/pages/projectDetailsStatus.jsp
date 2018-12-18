<%-- 
    Document   : projectDetailsStatus
    Created on : Dec 18, 2018, 12:31:02 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/natureFlower.jpg">
        <div align="center">
            <table border="1">
                <th>Employee Name</th>
                <th>Manager Name</th>
                <th>Task Name</th>
                <th>Task Type</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                <th>Delay</th>
                <th>Delay</th>
                <c:forEach var="pd" items="${listProject}">
                    
                </c:forEach> 
            </table>
        </div>
    </body>
</html>

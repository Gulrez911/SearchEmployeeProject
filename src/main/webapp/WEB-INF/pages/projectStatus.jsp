<%-- 
    Document   : demo
    Created on : Dec 24, 2018, 12:53:25 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/natureFlower.jpg">
        <div align="center">
            <table border="1">

                <th style="color:red">Employee Name</th>
                <th style="color:red">Manager Name</th>
                <th style="color:red">Task Name</th>
                <th style="color:red">Task Type</th>
                <th style="color:red">Start Date</th>
                <th style="color:red">End Date</th>
                <th style="color:red">Status</th>
                <th style="color:red">Delay</th>


                <c:forEach var="d" items="${listProject}">
                    <tr style="color:black">

                        <td>${d.emp_name}</td>
                        <td>${d.name}</td>
                        <td>${d.task_Name}</td>
                        <td>${d.task_Type}</td>
                        <td>${d.tStartDate}</td>
                        <td>${d.tEndDate}</td>
                        <td>${d.status}</td>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

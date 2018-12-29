<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Project Details</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/abstract.jpg">
        <div align="center">
            <table border="1">
                <th>Developer Name</th>
                <th>Task Name</th>
                <th>Task Type</th>
                <th>Task Start Date</th>
                <th>Task End Date</th>
                <th>Task Status</th>
                <th>Task Submit Date</th>
                    <c:forEach var="dTO" items="${taskDTOs}">
                    <tr>

                        <td>${dTO.emp_name}</td>
                        <td>${dTO.task_Name}</td>
                        <td>${dTO.task_Type}</td>
                        <td>${dTO.tStartDate}</td>
                        <td>${dTO.tEndDate}</td>
                        <td>${dTO.status}</td>
                        <td>${dTO.tsubDate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>>
    </body>
</html>
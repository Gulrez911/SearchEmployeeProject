<%-- 
    Document   : demo
    Created on : Dec 24, 2018, 12:53:25 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/natureFlower.jpg">
        <div align="center">
            <center><a href="/SpringMVCHibernateCRUD/downloadReport"><font style="color:blue" size="4">Download Task Report</font></a><br></center>

            <table border="1">

                <th style="color:red">Employee Name</th>
                <th style="color:red">Manager Name</th>
                <th style="color:red">Task Name</th>
                <th style="color:red">Task Type</th>
                <th style="color:red">Start Date</th>
                <th style="color:red">End Date</th>
                <th style="color:red">Status</th>
                <th style="color:red">Delay</th>


                <c:set var="total"></c:set>
                <c:forEach var="d" items="${listProject}">
                    <tr style="color:black">

                        <td>${d.emp_name}</td>
                        <td>${d.name}</td>
                        <td>${d.task_Name}</td>
                        <td>${d.task_Type}</td>
                        <td>${d.tStartDate}</td>
                        <td>${d.tEndDate}</td>
                        <td>${d.status}</td>
                        <td>
                            <fmt:parseDate pattern="yyyy-mm-dd" value="${d.tEndDate}" var="a"/>
                            <c:set value="${a.time/(1000*60*60*24)}" var="start"/>
                            <fmt:parseDate pattern="yyyy-mm-dd" value="${d.tStartDate}" var="b"/>
                            <c:set value="${b.time/(1000*60*60*24)}" var="end"></c:set>
                            <c:set value="${start-end}" var="difference"></c:set>
                            <fmt:parseNumber var="days" integerOnly="true" type="number" value="${difference}"></fmt:parseNumber>
                            Delay Days ${days}
                            <c:set value="${total+days}" var="total"/>
                        </td>

                    </tr>
                </c:forEach>
                <p align="right">  Total Delay days::${total}</p>
            </table>

        </div>
    </body>
</html>

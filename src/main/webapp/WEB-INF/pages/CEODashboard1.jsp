<%-- 
    Document   : CEODashboard
    Created on : Dec 18, 2018, 10:55:29 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>   


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <style type="text/css">
            #w{
                color: red;
            }
        </style>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/wood.jpg">

        <div align="center">
            <form action="downloadProjectReport" method="post">
                <input type="submit" value="Download Task Report" > 
            </form>
            <table border="1">
                <th>Project Name</th>
                <th>Delay</th>
                    <c:forEach var="pd" items="${listProject}">

                    <tr>
                        <td><a href="displayProjectDetails?project_id=${pd.project_id}">${pd.project_Name}</td>
                        <td>
                            <c:set value="${pd.pstart_Date.time/(1000*60*60*24)}" var="datediff"/>
                            <c:set value="${pd.pEnd_Date.time/(1000*60*60*24)}" var="datediff1" />

                            <c:set value="${ datediff1-datediff}" var="datediff2"/>
                            <fmt:parseNumber var="j" integerOnly="true" type="number" value="${datediff2}" />  
                            Expected time:${j} Days
                            </br>
                            <c:set var="date14" value="0" scope="session"/>
                            <c:set var="a" value="0"/>
                            <c:forEach var="tl" items="${tasklist}">

                                <c:if test="${pd.project_id==tl.projectId }">
                                    <c:choose>
                                        <c:when test="${  empty tl.tSub_Date  }">
                                            <c:set var="Datee1" value="<%=new java.util.Date()%>" />  
                                            <c:set value="${Datee1.time/(1000*60*60*24)}" var="date14" scope="session"/>
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:parseDate pattern="yyyy-MM-dd" value="${tl.tSub_Date }" var="date11"/>
                                            <c:set value="${date11.time/(1000*60*60*24)}" var="date14" scope="session"/>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>

                                <c:if test="${a lt date14 }">
                                    <c:set var="a" value="${date14 }"/>
                                </c:if>

                            </c:forEach>

                            <c:choose>
                                <c:when test="${a eq 0 }">
                                    <c:set var="j1" value="0"/>
                                </c:when>
                                <c:otherwise>
                                    <c:set value="${a-datediff1}" var="fd"/>
                                    <fmt:parseNumber var="j1" integerOnly="true" type="number" value="${fd+j}" />
                                </c:otherwise>
                            </c:choose>
                            completed time: ${j1} Days
                            </br>
                            <c:set var="deviation" value="${j1-j }"/>
                            <c:if test="${ deviation lt 1}">
                                <c:set var="deviation" value="0"/>
                            </c:if>
                            delay time:${deviation } Days
                        </td>
                    </tr>

                </c:forEach> 
            </table>
        </div>
    </body>
</html>

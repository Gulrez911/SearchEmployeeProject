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
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/wood.jpg">
        <h1>CEO Dashboard</h1>
        <div align="center">
            <table border="1">
                <th>Project Name</th>
                <th>Delay</th>
                    <c:forEach var="pd" items="${listProject}">
                    <tr>
                        <td><a href="displayProjectDetails?project_id=${pd.project_id}">${pd.project_Name}</td>
<<<<<<< HEAD
                       
=======
                        <td>
                       <c:set value="${pd.pstart_Date.time/(1000*60*60*24)}" var="datediff"/>
                         <c:set value="${pd.pEnd_Date.time/(1000*60*60*24)}" var="datediff1"/>
                          <c:set value="${datediff1-datediff }" var="datediff2"/>
                           <fmt:parseNumber var="j" integerOnly="true" type="number" value="${datediff2}" />  
                        Expected time: ${j} Days
                       <%--   <c:set var="etdate" value="" scope="session"/>
                          <c:set var="tdate" value="" scope="session"/> --%>
                         <c:forEach var="tl" items="${tasklist}">
                        
                         <c:if test="${pd.project_id==tl.projectId }">
                          <c:choose>
                          <c:when test="${ empty tl.tSub_Date }">
                           <c:set var="Datee" value="<%=new java.util.Date()%>" />  
                          <fmt:parseDate pattern="yyyy-mm-dd" value="${Datee }" var="edate"/>
                          <c:set value="${edate.time/(1000*60*60*24)}" var="t1date" scope="session"/>
                          </c:when>
                          <c:otherwise>
                            <fmt:parseDate pattern="yyyy-mm-dd" value="${tl.tSub_Date }" var="date"/>
                         <c:set value="${date.time/(1000*60*60*24)}" var="t1date" scope="session"/>
                          </c:otherwise>
                          </c:choose>
                     
                          <c:forEach var="tll" items="${tasklist}">
                          <c:choose>
                          <c:when test="${ empty tll.tSub_Date }">
                          <c:set var="Datee1" value="<%=new java.util.Date()%>" />  
                           <fmt:formatDate pattern="yyyy-mm-dd" value="${Datee1 }" var="edate1"/>
                            <c:set value="${edate1.time/(1000*60*60*24)}" var="tdate1" scope="session"/>
                          </c:when>
                          <c:otherwise>
                          <fmt:parseDate pattern="yyyy-mm-dd" value="${tll.tSub_Date }" var="date1"/>
                         <c:set value="${date.time/(1000*60*60*24)}" var="tdate1"  scope="session"/>
                          </c:otherwise>
                          </c:choose>
                          <c:if test="${t1date gt tdate1 }">
                          <c:set value="${t1date }" var="t1date" scope="session"/>
                          
                          </c:if>
                          
                          <c:if test="${t1date lt tdate1 }"></c:if>
                          <c:set value="${tdate1 }" var="t1date" scope="session"/>
                          </c:forEach>
                        
                        
                        
                         
        <%--                  <c:choose>
                         <c:when test="${ empty tl.tSub_Date }">
                          <c:set var="Datee" value="<%=new java.util.Date()%>" />  
                          <fmt:formatDate pattern="yyyy-mm-dd" value="${Datee }" var="edate"/>
                          <c:set value="${Datee.time/(1000*60*60*24)}" var="etdate"/>
                            <c:set value="${pd.pEnd_Date.time/(1000*60*60*24)}" var="pdate"/>
                              <c:set value="${etdate+tdate}" var="ttdate"/>
                           <c:set value="${etdate-pdate }" var="pdate4"/>  
                         </c:when>
                         <c:otherwise>
                         <fmt:parseDate pattern="yyyy-mm-dd" value="${tl.tSub_Date }" var="date"/>
                         <c:set value="${date.time/(1000*60*60*24)}" var="tdate"/>
                          <fmt:parseDate pattern="yyyy-mm-dd" value="${pd.pEnd_Date }" var="dated"/>
                        <c:set value="${dated.time/(1000*60*60*24)}" var="pdate"/>
                        <c:set value="${etdate+tdate}" var="ttdate"/>
                           <c:set value="${tdate-pdate }" var="pdate3"/> 
                         
                         </c:otherwise>
                         </c:choose> --%>
                         <%-- <fmt:parseDate pattern="dd-mm-yyyy" value="${tl.tSub_Date }" var="date"/>
                         <c:set value="${date.time/(1000*60*60*24)}" var="tdate"/>
                        <c:set value="${pd.pEnd_Date.time/(1000*60*60*24)}" var="pdate"/>
                          <c:set value="${tdate-pdate }" var="pdate3"/>
                          --%>
                         </c:if>
                        </c:forEach> 
                        </br> 
                     <%--    <c:set value="${ttdate-pdate}" var="fdate"/> --%>
 <%--                     <c:set value="${pdate3+pdate4}" var="pdate5"/>
                        <fmt:parseNumber var="j1" integerOnly="true" type="number" value="${pdate3}" />
                        <fmt:parseNumber var="j1" integerOnly="true" type="number" value="${fdate}" />
                        <fmt:parseNumber var="j1" integerOnly="true" type="number" value="${pdate5+j}" /> --%>
                        <c:set value="${pd.pEnd_Date.time/(1000*60*60*24)}" var="datediff1"/>
                        <c:set value="${task+datediff1}" var="j1 "/>
                        completed time: ${t1date-datediff1} Days
                        
                        
                         </br>
                         <c:set value="${j1-j }" var="j2"/>
                         delay time:${j2} Days
                     
                        </td>
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
                    </tr>
                </c:forEach> 
            </table>
        </div>
    </body>
</html>
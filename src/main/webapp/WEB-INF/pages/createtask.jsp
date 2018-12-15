<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Task</title>
</head>
<body
       background="<%=request.getContextPath()%>/resources/images/macbook_apple.jpg">
<div class="content">
            <form:form action="" method="post" commandName="taskdetails">  
                <table align="center">
                    <tr>
                        <td style="color: black">Task Name:</td>
                        <td><form:input name="task_Name" path="task_Name" type="text" id="tn" /></td>
                    </tr>
                    <tr>
                    <td style="color: black">Task Types:</td>
                        <td><form:select path="task_Type" name="task_Type" >

                                <form:options items="${task_Type}" />
                                
                                </form:select></td>

                        <td colspan="2" align="right"><input type="submit"
                                                             value="CREATE" id="bt"></td>
                    </tr>

                </table>
                
             <%--   // List copy from home.jsp //
                
                 <p style="color:white">${error}</p>
            <p style="color:black">${message}</p>
            <table border="1">

                <th style="color:red">Task Type</th>
                <th style="color:red">Task Name</th>
                <th style="color:red">Status</th>
                

                
                 <c:forEach var="taskdetails" items="${tdlist}">
                    <tr style="color:black">

                        <td>${taskdetails.task_Type}</td>
                        <td>${taskdetails.task_Name}</td>
                        <td>${taskdetails.status}</td>
                 </c:forEach>     
                     --%>
                       
                
            <div style="color: red">${error}</div> 
            </form:form>
        </div> 







</body>
</html>
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

            <h1 style="color: orangered" align="center">Create Task</h1>
            <form:form action="createtask" method="post" modelAttribute="taskdetails" commandName="taskdetails">  
                <table align="center">
                    <form:hidden path="projectId" />
                    <form:hidden path="managerId" />
                    <tr>
                        <td style="color: black">Task Name:</td>
                        <td><form:input name="task_Name" path="task_Name" type="text" id="tn" /></td>
                    </tr>
                    <tr>
                        <td style="color: black">Task Types:</td>
                        <td><form:select path="task_Type" name="task_Type" >

                                <form:options items="${task_Type}" />

                            </form:select></td>

                    <tr>

                        <td colspan="2" align="right"><input type="submit"
                                                             value="CREATE" id="bt"></td>
                    </tr>

                </table>
            </form:form>



            <table border="1"  align="center">

                <th style="color:red">Task Type</th>
                <th style="color:red">Task Name</th>
                <th style="color:red">Status</th>



                <c:forEach var="td" items="${listtask}">
                    <tr style="color:black">

                        <td>${td.task_Type}</td>
                        <td>${td.task_Name}</td>
                        <!--<td> <a href="asssign?task_id=${td.task_id}">${td.status}</a></td>-->
                        <!--<td>  <a href="asssign?task_id=${taskdetails.task_id}&project_id=${pd.project_id}&mgrid=${mid}">${td.status}</a></td>-->

                        <td><a href="asssign?task_id=${td.task_id}&project_id=${td.projectId}&mgrid=${td.managerId}"> ${td.status}</a></td>
                    </c:forEach>     

                 
                 </table>
                 
                 <form:form action="">
                 
                 <table>
                 
                 <tr>
                 <td>
                 
                 <input type="submit" Value="Back">
                 
                 </td>
                 
                 
                 </tr>
                 
                 </table>
                 
                 
                 
                 </form:form>
                 
                 
                 
                 
                    </div> 







                    </body>
                    </html>
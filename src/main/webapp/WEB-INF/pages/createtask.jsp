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

                    </form:form></div>

<div align="right">
			<form:form action="backtoproject"  commandName="e">

			<table>
				<tr>
					<td>
					 
						<form:hidden path="email" name="email" />
<input type="submit" value="Back">
					</td>
					
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


                       <%--  <td>  <a href="asssign?task_id=${td.task_id}&project_id=${pd.project_id}&mgrid=${mid}">${td.status}</a> --%>
                        
                         
                         
                           
                        
                        
                 
                        <!--<td>  <a href="asssign?task_id=${taskdetails.task_id}&project_id=${pd.project_id}&mgrid=${mid}">${td.status}</a></td>-->



                      <%--   <td>  <a href="asssign?task_id=${taskdetails.task_id}&project_id=${taskdetails.projectId}&mgrid=${taskdetails.managerId}">${taskdetails.status}</a></td>
                         --%>
                        
                        
                        <td><a href="asssign?task_id=${td.task_id}&project_id=${td.projectId}&mgrid=${td.managerId}"> ${td.status} </a></td> 
                        
                        <td> <a href="delete?taskid=${td.task_id}">delete</a></td>
                    </c:forEach>     



                    </div> 








 </body>
 </html>



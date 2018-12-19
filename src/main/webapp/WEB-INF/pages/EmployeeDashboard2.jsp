<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form:form action="/SpringMVCHibernateCRUD/Empedit" method="post"
		modelAttribute="employee" commandName="employee">
		<form:hidden path="email" />
		<input type="submit" value="Edit Profile">
	</form:form>
	<form:form action="/SpringMVCHibernateCRUD/editTask" method="POST"
		commandName="taskdetails" modelAttribute="employee">
		
  <form:hidden path="email" />  
		<%-- <form:hidden path="task_id" />
		<form:hidden path="task_Type" />
		<form:hidden path="task_Name" />
		<form:hidden path="tStart_Time" />
		<form:hidden path="tEnd_Time" /> --%>
		<%-- <form:input path="task_Name" /> --%>
		<table border="1">

			<th style="color: red">Task Type</th>
			<th style="color: red">Task Name</th>
			<th style="color: red">Start Date</th>
			<th style="color: red">End Date</th>
			<th style="color: red">Manager Name</th>
			<th style="color: red">Status</th>
			<th style="color: red">Action</th>



			<c:forEach var="tlist" items="${tlist}">
				<tr style="color: black">

					<td>${tlist.task_Type}</td>
					<td>${tlist.task_Name}</td>
					<td>${tlist.tStart_Time}</td>
					<td>${tlist.tEnd_Time}</td>
					<td>${tlist.status}</td>
					 <td><form:select path="status" name="taskStatus">
			  <%-- <form:option value="${tlist.status}"></form:option>  --%>

				<form:options items="${taskStatus}" />

			</form:select>	
			</td> 
			
		  <input type="hidden" name="tid" value="${tlist.task_id}"> 
		   
		  <%-- <%
		  String s="${tlist.task_id}";
		  Cookie cookie=new Cookie("tid",s);
		  response.addCookie( cookie );
		  %> --%>
		
					<td><input type="submit" value="Save Changes"></td>
					<td><a href="authenticate">Save changes</a>
				</tr>
				
			</c:forEach>
			<tr>

				<!--  <td><input type="submit" value="Done"></td> -->
			</tr>
			
		</table>
	</form:form>
</body>
</html>
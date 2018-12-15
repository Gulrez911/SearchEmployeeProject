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
		 <form:hidden path="email"/>
		 <input type="submit" value="Edit Profile" > 
	</form:form>

	<table border="1">

		<th style="color: red">Task Type</th>
		<th style="color: red">Task Name</th>
		<th style="color: red">Start Date</th>
		<th style="color: red">End Date</th>
		<th style="color: red">Manager Name</th>
		<th style="color: red">Status</th>



		<c:forEach var="employee" items="${elist}">
			<tr style="color: white">

				<td>${employee.name}</td>
				<td>${employee.email}</td>
				<td>${employee.address}</td>
				<td>${employee.telephone}</td>
				<td>${employee.category}</td>
				<td>${employee.category}</td>
				<td><input type="submit" value="Done">
			</tr>
		</c:forEach>
		<tr>

			<!--  <td><input type="submit" value="Done"></td> -->
		</tr>
	</table>
</body>
</html>
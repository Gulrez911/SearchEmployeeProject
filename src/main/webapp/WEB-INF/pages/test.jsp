<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
table {
	border-collapse: collapse;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Skills</title>
</head>
<body
	background="<%=request.getContextPath()%>/resources/images/gal.jpg">
	<div align="center">
		<h1 style="color: white">Skills Tracker: Add Skill Page</h1>
		<form:form action="saveTest" method="post" modelAttribute="skill"
			commandName="skill">
			<table>
				<form:hidden path="skill_Id" />
				<tr>
					<td style="color: white">Name:</td>
					<td><form:input path="skill_name" name="skill_name"
							id="skill_name" /></td>
					<br>
					<td colspan="2" align="center"><input type="submit"
						value="Add"></td>
				</tr>
			</table>
		</form:form>
		<table border="1">


			<th>Skills</th>
			<th>Action</th>

			<c:forEach var="skill" items="${listSkill}">
				<tr>

					<td>${skill.skill_name}</td>
					<td><a href="editTest?skill_Id=${skill.skill_Id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteTest?skill_Id=${skill.skill_Id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>CREATE PROJECT</h1>
	</center>
	<div>

		<form:form action="cproject" method="post"
			modelAttribute="projectdetails" commandName="projectdetails">
			<table align="cproject">

				<form:hidden path="project_id" />
				<tr>
					<td>Project Name:</td>
					<td><form:input type="text" path="project_Name" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:textarea path="project_desc" rows="5" cols="5" /></td>
				</tr>
				<tr>

					<td>Project Start Date:</td>
					<td><form:input type="Date" path="pstart_Date" id="startDate"
							name="startDate" /></td>
				</tr>
				<tr>
					<td>Project End Date:</td>
					<td><form:input type="Date" path="pEnd_Date" id="endDate"
							name="endDate" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Create Project"></td>

				</tr>


			</table>
		</form:form>
	</div>
	<%-- <div>
		<div align="right" style="size: 50%">
			<h1>Right</h1>
		</div>

		<div align="left" style="size: 50%">
			<h1>left</h1>
			<form action="showproject" commandName="projectdetails">
				<table border="1">
					<th>PROJECTS</th>
					<c:forEach var="projectdetails" items="${pdlist}">
						<tr>
							<td><a
								href="showproject?name=${projectdetails.project_Name}"
								style="color: greenyellow">${projectdetails.project_Name}</a></td>
						</tr>
					</c:forEach>
				</table>
			</form>

		</div>







	</div> --%>
</body>
</html>
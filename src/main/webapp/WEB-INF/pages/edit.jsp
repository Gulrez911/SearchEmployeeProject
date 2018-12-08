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


<body background="<%=request.getContextPath()%>/resources/images/macbook_apple.jpg">
	<div align="center">
		<h1 style="color: white">New/Edit Employee</h1>

		<%--<form:errors path="employee.*"/>--%>
		<form:form action="editEmployee" modelAttribute="employee"
			commandName="employee">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<form:hidden path="id" />
				<form:hidden path="otp" />
				<form:hidden path="id" />
				<tr>
					<td style="color: white">Name:</td>
					<td><form:input path="name" required="required" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td style="color: white">Email:</td>
					<td><form:input path="email" type="email" name="email"
							required="required" /></td>

				</tr>
				<tr>
					<td style="color: white">Address:</font></td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td style="color: white">Telephone: </font></td>
					<td><form:input path="telephone" required="required" /></td>
				</tr>

				<tr>
					<td style="color: white">Password:</td>
					<td><form:input path="password" type="password"
							required="required" /></td>
				</tr>

				<%-- <tr>
					<td style="color: white">OTP:</td>
					<td><form:input path="otp" readonly="true" /></td>
				</tr> --%>
				<tr>
					<td style="color: white">Status:</td>
					<td><form:input path="status" readonly="true" /></td>
				</tr>

				<tr>
					<td style="color: white">Skills: </font></td>
					<td><form:select path="skills" required="required">

							<form:options items="${listSkill}" />
						</form:select></td>
				</tr>
				
				

				<tr>
					<td></td>
					<td align="center"><input type="submit" value="Edit"></td>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>
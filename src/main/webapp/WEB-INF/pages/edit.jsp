
<<<<<<< HEAD
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


<body
	style="background-image: url('http://www.ppt123.net/beijing/UploadFiles_8374/201805/20180526063117156.jpg');">
	<div align="center">
		<h1 style="color: white">New/Edit Employee</h1>

		<%--<form:errors path="employee.*"/>--%>
		<form:form action="editEmployee" modelAttribute="employee"
			commandName="employee">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
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

				<tr>
					<td style="color: white">OTP:</td>
					<td><form:input path="otp" readonly="true" /></td>
				</tr>
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

   

    
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body
	background="<%=request.getContextPath()%>/resources/images/macbook_apple.jpg">


	<div align="center">
		<h1 style="color: orangered">Edit Employee</h1>

		<form:form action="editEmployee" method="post"
			modelAttribute="employee" commandName="employee">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<form:hidden path="id" />
				<tr>
					<td style="color: yellow">Name:</td>
					<td><form:input path="name" required="required" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td style="color: yellow">Email:</td>
					<td><form:input path="email" type="email" required="required" /></td>
				</tr>
				<tr>
					<td style="color: yellow">Address:</font></td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>

					<td style="color: yellow">Telephone: </font></td>
					<td><form:input path="telephone" /></td>

				</tr>

				<tr>
					<td style="color: white">Password:</td>
					<td><form:input path="password" type="password"
							required="required" /></td>
				</tr>
				<tr>
					<td style="color: white">Aadhar No.:</td>
					<td><form:input path="aadhar" required="required" /></td>
					<td><form:errors path="aadhar" cssClass="error" /></td>
				</tr>
				<tr>
					<td style="color: white">Pan No.:</td>
					<td><form:input path="pan" required="required" /></td>
					<td><form:errors path="pan" cssClass="error" /></td>
				</tr>
				<tr>
					<td style="color: white">User Type:</td>
					<td><form:select path="category" name="userTypes"
							readonly="true">

							<form:options items="${userTypes}" />

						</form:select></td>
				</tr>

				<tr>
					<td style="color: white">ManagerId</td>
					<td><form:input path="managerId" /></td>
				</tr>
				<tr>
					<td style="color: white">Status</td>
					<td><form:input path="status" readonly="true" /></td>
				</tr>


				<%--<tr>
                        <td style="color:white">OTP:</td>
                        <td><form:input path="otp" /></td>
                    </tr> --%>



				<tr>
					<td style="color: yellow">Skills: </font></td>
					<td><form:select path="skills" required="true">

							<form:options items="${listSkill}" />
						</form:select>
					<td>
				</tr>

				<tr>
					<td><input type="submit" value="Send OTP" name="action1" /></td>
					<td colspan="2" align="center"><input type="submit"
						value="Save" name="action2"></td>
				</tr>
			</table>
		</form:form>


	</div>
</body>
</html>
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git

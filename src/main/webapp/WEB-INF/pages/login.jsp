
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login.</title>
<style>
#nm {
	background-image: url('/WEB-INF/images/un.png');
	background-repeat: no-repeat;
	background-position: left;
	background-size: 25px;
	border-radius: 25px
}
#bt {
	/*  border: 1px solid;
    padding: 10px;
    box-shadow: 3px 4px; */
	border-radius: 25px
}

#pw {
	border-radius: 25px
}

#slt items:hover select {
	display: block;
	border-radius: 10px
}

#lbl {
	font-weight: bold;
}

#fm {
	
}
</style>
</head>
<body
	background="<%=request.getContextPath()%>/resources/images/india-wallpaper.jpg">
	

	<fieldset
		style="width: 500px; margin: 50px auto; padding: 5px; box-shadow: 5px 7px">
		<legend>
			<h1 style="color: white; text-align: center;">Login</h1>
		</legend>


		<form:form action="authenticate" method="post" commandName="employee">
			<table align="center">
				<tr>
					<td style="color: white">User Name:</td>
					<td><form:input name="email" path="email" type="email" id="nm"/></td>
				</tr>
				<tr>
					<td style="color: white">Password:</td>
					<td><form:input name="password" path="password"
							type="password" id="pw"/></td>
				</tr>
				<tr>
					<td><form:select path="category" name="userType">

							<form:options items="${userTypes}" />

						</form:select></td>

					<td colspan="2" align="right"><input type="submit"
						value="LOGIN" id="bt"></td>
				</tr>

			</table>
			<div style="color: red">${error}</div>
		</form:form>
	</fieldset>



</body>
</html>

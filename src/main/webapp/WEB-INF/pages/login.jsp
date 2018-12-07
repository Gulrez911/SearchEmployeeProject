
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login.</title>
<style>
#nm{
	
	background-image:url('/WEB-INF/images/un.png');
	 background-repeat:no-repeat;
	background-position:left;
	background-size: 25px; 
		 border-radius: 25px
	
}
#bt{
/*  border: 1px solid;
    padding: 10px;
    box-shadow: 3px 4px; */
     border-radius:25px
}
#pw{
 border-radius: 25px
}
#slt items:hover select
{
display:block;
 border-radius: 10px
}
#lbl
{
font-weight: bold;
}
#fm
{
     
    
}
</style> 
</head>
<body
	background="<%=request.getContextPath()%>/resources/images/india-wallpaper.jpg">
	<!--        <a href="/SpringMVCHibernateCRUD/employeelist">EmployeeList</a>-->\
	<fieldset style="width: 500px; margin:  50px auto;padding: 5px;box-shadow: 5px 7px">
	<legend><h1 style="color: white;text-align: center;" >Login</h1></legend>

	<!--            <a href="/SpringMVCHibernateCRUD/test">Add Skill</a>-->
	<!--        <a href="/SpringMVCHibernateCRUD/employeelist">EmployeeList</a>-->
	<!-- <h1 style="color: white" align="center">Login</h1> -->

	<form:form action="authenticate" method="post" commandName="user">
		<table align="center">
			<tr>
				<td style="color: white" id="lbl">User Name:</td>
				<td><input name="userName" type="textbox"  autofocus="autofocus" id="nm" ></td>
			</tr>
			<tr>
				<td style="color: white" id="lbl">Password:</td>
				<td><input name="password" type="password" id="pw"></td>
			</tr>
			<tr>
				<td id="slt"><form:select path="category" name="userTypes" id="slt">

						<form:options items="${userTypes}" />

					</form:select></td>

				<td colspan="2" align="right"><input type="submit"
					value="LOGIN" id="bt"></td>
			</tr>
		</table>
		<div style="color: red">${error}</div>
	</form:form></fieldset>

	<!--            <a href="/SpringMVCHibernateCRUD/test">Add Skill</a>-->

</body>
</html>

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
<center><h1>CREATE PROJECT</h1></center>
<div>
	<form action="">
		<table>
            <tr>
           		 <td>Project Name:</td>
            	<td><input type="text" path="project_Name"></td>
            </tr>
            <tr>
            	 <td>Description:</td>
             	 <td><textarea rows="5" cols="5" path="project_desc"></textarea></td>
            </tr>
            <tr>
            	<td>Project Start Date:</td>
           		 <td></td>
            </tr>
            <tr>
            	<td>Project End Date:</td>
            	<td></td>
            </tr>
            <tr>
               <td><input type="submit" value="Create Project"></td>
            
            </tr>


		</table>
	</form>
</div>
</body>
</html>
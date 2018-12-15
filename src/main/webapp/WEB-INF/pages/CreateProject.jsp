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
            <h1 style="color: orangered">Create Project</h1>

<<<<<<< HEAD
            <form:form action="cproject" method="post"
                       modelAttribute="projectdetails" commandName="projectdetails">
                <table>
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
                        <td><form:input path="pstart_Date"></form:input></td>
                    </tr>
                    <tr>
                        <td>Project End Date:</td>
                       <td><form:input path="pEnd_Date"/></td>
                    </tr>
=======
		<form:form action="cproject" method="post"
			modelAttribute="projectdetails" commandName="projectdetails">
			<table>
				<form:hidden path="project_id" />
				<tr>
					<td>Project Name:</td>
					<td><form:input type="text" path="project_Name" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:textarea path="project_desc" rows="5" cols="5" /></td>
				</tr>
>>>>>>> origin/master

<<<<<<< HEAD
                    <tr>
                        <td><input type="submit" value="Create Project"></td>
=======

				<tr>
					<td>Project Start Date:</td>
					<td><form:input path="pstart_Date" /></td>
				</tr>
				
				<tr>
					<td>Project End Date:</td>
					<td><form:input type="text" path="pEnd_Date" id="endDate"
							name="endDate" /></td>
				</tr> 
>>>>>>> origin/master

<<<<<<< HEAD
                    </tr>
                </table>
            </form:form>
=======
				<tr>

					<td><input type="submit" value="Create Project"></td>

				</tr>
			</table>
		</form:form>
>>>>>>> origin/master


        </div>
    </body>
</html>

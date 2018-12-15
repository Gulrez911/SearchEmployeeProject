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

		<form:form action="cproject" method="post"
			modelAttribute="projectDetails" commandName="projectDetails">
			<table>
				<form:hidden path="project_id" />
				<tr>
					<td>Project Name:</td>
					<td><form:input type="text" path="project_Name" name="project_Name"/></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:textarea path="project_desc" rows="5" cols="5" name="project_Name"/></td>
				</tr>




				<tr>
					<td>Project Start Date:</td>
					<td><form:input path="pstart_Date"  name="pstart_Date"/></td>
				</tr>
				
				<tr>
					<td>Project End Date:</td>
					<td><form:input type="text" path="pEnd_Date" id="endDate"
							name="endDate" /></td>
				</tr> 



				<tr>

					<td><input type="submit" value="Create Project"></td>

				</tr>
			</table>
			
			
		<%-- 	<br>
			
			<table border="1">
					<th>PROJECTS</th>
					
					<c:forEach var="projectDetails" items="${pdlist}">
						<tr>
						<td>${projectDetails.project_Name}</td>
							
						</tr>
					</c:forEach>
				</table>
	 --%>
	</form:form>

	<%-- </div>
	
	<!-- <div>
		<div align="right" style="size: 50%">
			<h1>Right</h1>
		</div> -->

		<div align="left" style="size: 50%">
			<h1>left</h1>
			<form:form action=""  commandName="projectDetails">
				
			</form:form>
		</div>

       



<<<<<<< HEAD


<!-- 	</div>
	 -->
	
	
	
	 --%>
	
	     <table border="1">

        <th>Project Name</th>
                <th>Create Task</th>
                    <c:forEach var="pd" items="${listProject}">
                    <tr>

                        <td>${pd.project_Name}</td>
                        <td>
                            <a href="Create Task?project_id=${pd.project_id}">Create Task</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>


        </div>
    </body>

</html>

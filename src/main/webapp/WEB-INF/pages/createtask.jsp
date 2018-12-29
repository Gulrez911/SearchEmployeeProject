<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Create Task</title>
    </head>
    <body
        background="<%=request.getContextPath()%>/resources/images/bg2.jpg">
        <div class="content">

            <h1 style="color: orangered" align="center">Create Task</h1>
            <form:form action="createtask" method="post" modelAttribute="taskdetails">  
              <table align="center">
               
                    <form:hidden path="projectId" />
                    <form:hidden path="managerId" />
                    <form:hidden path="Emp_Email"/>
                    <tr>
                        <td style="color: black">Task Name:</td>
                        <td><form:input name="task_Name" path="task_Name" type="text" id="tn" /></td>
                    </tr>
                    <tr>
                        <td style="color: black">Task Types:</td>
                        <td><form:select path="task_Type" name="task_Type" >
                                <form:options items="${task_Type}" />
                            </form:select></td>
                    <tr>

                           <input type="hidden" name="em" value="${em }"/>
                        <td colspan="2" align="right"><input type="submit"  value="CREATE" id="ct"></td>

                    </tr>
            </form:form></div>
        <div align="right">
            <form:form action="backtoproject" commandName="e">

                <table>
                    <tr>
                        <td>

                            <%--  	<form:hidden path="email" name="email"/>
                                    
                                    <input type="submit" value="Back">
                            --%>




                            <%--  <a href="backtoproject?email=${e.email}"><font style="color:Dark blue" size="5">Back</font></a>  --%>
                             <a href="backtoproject?email=${em}"><font style="color:Dark blue" size="5">Back</font></a> 
                          


                        </td>
                </table>
               <!--  <tr>
                <div align="right"><td>

                        <a href="logout"><font style="color:Dark blue" size="5">LogOut</font></a>
                </div>
            </tr>  -->
            
            
        
        
            
            
           <%--  <form:form action="backtoprj" method="post" >

           
                    <td>
                        <input type="submit" value="Back"></form:form>

                    </td> --%>

        </form:form>


        <table border="1"  align="center">

            <th style="color:red">Task Type</th>
            <th style="color:red">Task Name</th>
            <th style="color:red">Status</th>



            <c:forEach var="td" items="${listtask}">
                <tr style="color:black">

                    <td>${td.task_Type}</td>
                    <td>${td.task_Name}</td>

    <td><a href="asssign?task_id=${td.task_id}&project_id=${td.projectId}&mgrid=${td.managerId}&em=${em}"> ${td.status} </a></td> 

    <td> <a href="delete?task_id=${td.task_id}&project_id=${td.projectId}&mgrid=${td.managerId}&em=${em}">delete</a></td>


                </c:forEach>     
                </div> 

        </table>

    </div> 

<div align="right">
        <form action="logout" method="get">
        <input type="submit" value="Logout"> 
        </form></div>



</body>
</html>



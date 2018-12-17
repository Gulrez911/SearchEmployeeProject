<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Contact</title>
        <style>
            .error { 
                color: red; font-weight: bold; 
            }
        </style>

    </head>
    <body background="<%=request.getContextPath()%>/resources/images/macbook_apple.jpg">


        <div align="center">
            <h1 style="color:orangered">Allocate Task</h1>

            <form:form action="taskAllocated" method="post" modelAttribute="td" commandName="td">
                <form:errors path = "*" cssClass = "errorblock" element = "div" />
                <table>
                    <form:hidden path="projectId" />
                    <form:hidden path="managerId" />
                    <form:hidden path="task_id" />
                    <tr>
                        <td style="color:white">Task Type: </td>
                        <td><form:input path="task_Type"  /></td>
                        <td><form:errors path="task_Type" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color: black">Task Name:</td>
                        <td><form:input name="task_Name" path="task_Name" type="text" id="tn" /></td>
                    </tr>

                    <tr>
                        <td>

                        </td>
                    </tr>

                    <tr>
                        <td style="color:white"> Assign: </font></td>
                        <td>
                            <form:select path="Emp_Email" required ="true">

                                <form:options items="${employeeEmail}" />
                            </form:select>

                        <td>

                    </tr>  

                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Save" name="action2"></td>
                    </tr>
                </table>
            </form:form>


        </div>
    </body>
</html>

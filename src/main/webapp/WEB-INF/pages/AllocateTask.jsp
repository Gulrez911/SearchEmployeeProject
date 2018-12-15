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

            <form:form action="saveEmployee" method="post" commandName="td">
                <form:errors path = "*" cssClass = "errorblock" element = "div" />
                <table>
                    <tr>
                        <td style="color:white">Task Type: </td>
                        <td><form:input path="task_Type"  required="required"/></td>
                        <td><form:errors path="task_Type" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color:white">Task Name: </td>
                        <td><form:input path="task_Name" /></td>

                    </tr>

                    <tr>
                        <td style="color:white">Start Date: </font></td>
                        <td><form:input path="tStart_Time" type="date" /></td>
                    </tr>
                    <tr>
                        <td style="color:white">End Date: </font></td>
                        <td><form:input path="tEnd_Time" type="date"/></td>
                    </tr>

                    <!--                    <tr>
                                            <td style="color:white"> Assign: </font></td>
                                            <td>
                    <%--<form:select path="emp_email" required ="true">--%>

                    <%--<form:options items="${listEmail}" />--%>
                    <%--</form:select>--%>

                <td>

            </tr>-->

                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Save" name="action2"></td>
                    </tr>
                </table>
            </form:form>


        </div>
    </body>
</html>

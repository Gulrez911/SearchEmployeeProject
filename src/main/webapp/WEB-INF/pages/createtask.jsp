<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Task</title>
</head>
<body>
<div class="content">
          <!--  < <form:form action="" method="post" commandName="Task_Details">  -->
                <table align="center">
                    <tr>
                        <td style="color: black">Task Name:</td>
                        <td><form:input name="task_Name" path="task_Name" type="task_Name" id="nm" /></td>
                    </tr>
                    <tr>
                        <td><form:select path="Tasktype" name="task_Type">

                                <form:options items="${task_Type}" />
                    </tr>            

                            </form:select></td>

                        <td colspan="2" align="right"><input type="submit"
                                                             value="CREATE" id="bt"></td>
                    </tr>

                </table>
                <div style="color: red">${error}</div> 
            </form:form>
        </div> 







</body>
</html>
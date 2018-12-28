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
        background="<%=request.getContextPath()%>/resources/images/bg2.jpg">


        <div align="center">
            <h1 style="color: orangered">Create Project</h1>

            <form:form action="cproject" method="post"
                       modelAttribute="pd" commandName="pd">
                <table>
                    <form:hidden path="project_id" />
                    <form:hidden path="manageremail" />
                    <tr>
                        <td>Project Name:</td>
                        <td><form:input type="text" path="project_Name" name="project_Name" required="true"/></td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td><form:textarea path="project_desc" rows="5" cols="5" name="project_Name"/></td>
                    </tr>
                    <tr>
                        <td>Project Start Date:</td>
                        <td><form:input path="pstart_Date" type="date" name="pstart_Date" required="true"/></td>
                    </tr>

                    <tr>
                        <td>Project End Date:</td>
                        <td><form:input path="pEnd_Date" type="date" id="endDate"
                                    name="endDate" required="true"/></td>
                    </tr> 

                    <tr>

                        <td><input type="submit" value="Create Project"></td>

                    </tr>
                </table>

                <table border="1" align="left">

                    <th style="color: red">Project Name</th>

                    <c:forEach var="pd" items="${listProject}">
                        <tr>

                            <td><a href="showtask?project_id=${pd.project_id}&mgrid=${mid}" style="color: Dark blue">${pd.project_Name}</a></td>

                        </tr>


                    </c:forEach>
                </table>

            </form:form>
        </div>
        <br>
    </div>
    <div align="right">
        <form:form action="managerpage"  commandName="e">
            
            <table>
                <tr>
                    <td>
                        <a href="managerpage?email=${e.email}&k=${k}">Employee List</a>
            </table>
        </form:form>
    </div>

    <div align="right">
        <form:form action="back" method="post" commandName="e">

            <table>
                <tr>
                    <td>
                        <input type="submit" value="Back">

                    </td>
                </tr>


</table>
 <tr>
   <div align="right"><td>
   
    <a href="logout"><font style="color:Dark blue" size="5">LogOut</font></a>
   
   </div>
</tr> 

</form:form>
</div>

</body>

</html>

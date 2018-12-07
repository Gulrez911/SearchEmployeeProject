<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Information</title>

  <style>
            .error { 
                color: red; font-weight: bold; 
            }
        </style>

</head>
<body>

<div align="center">
            <h1><font color="red"> Employee Information </font></h1>

            <%--<form:errors path="employee.*"/>--%>
            <form:form action="saveEmployee" method="post" modelAttribute="employee" commandName="employee" >
                <form:errors path = "*" cssClass = "errorblock" element = "div" />
                <table>
                    <form:hidden path="id"/>
                    <tr>
                        <td><font color="black">Name:</font></td>
                        <td><form:input path="name"  required="required"/></td>
                        <td><form:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><font color="black"> Email: </font></td>
                        <td><form:input path="email" type="email"  required="required"/></td>
                  
                    </tr>
                    <tr>
                        <td><font color="black">Address:</font></td>
                        <td><form:input path="address" /></td>
                    </tr>
                    <tr>
                        <td><font color="black"> Telephone: </font></td>
                        <td><form:input path="telephone" /></td>
                    </tr>
                    <tr>
                        <td><font color="black"> Skills: </font></td>
                        <td>
                            <form:select path="skills" name="listSkill" required="required">

                                <form:options items="${listSkill}" />
                            </form:select>
                        </td>
                         </tr>

                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Save" name="action2"></td>
                    </tr>
                </table>
            </form:form>

        </div>
        
    </body>
</html>
                        
                        
                        
                        



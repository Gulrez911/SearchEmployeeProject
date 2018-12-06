<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body style="background-color:blue">
 <div align="center">
            <h1 style="color:white">Employee Details</h1>

            <%--<form:errors path="employee.*"/>--%>
            <form:form action="editEmployee" method="post" commandName="employee">
                <form:errors path = "*" cssClass = "errorblock" element = "div" />
                <table>
                    <hidden path="id"/>
                    <tr>
                        <td style="color:white">Name:</td>
                        <td><input path="name"  required="required"/></td>
                        <td><errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color:white"> Email:</td>
                        <td><input path="email" type="email" name="email"  required="required"/></td>
                  
                    </tr>
                    <tr>
                        <td style="color:white">Address:</font></td>
                        <td><input path="address" /></td>
                    </tr>
                    <tr>
                        <td style="color:white"> Telephone: </font></td>
                        <td><input path="telephone" required="required"/></td>
                    </tr>
                    
                       <tr>
                        <td style="color:white">Password:</td>
                        <td><input path="password" type="password" required="required"/></td>
                    </tr>
                    
                   <tr>
                        <td style="color:white">Manager Id:</td>
                        <td><input path="ManagerId" readonly="true"/></td>
                    </tr>
                    
                    <tr>
                        <td style="color:white">Manager Name:</td>
                        <td><input path="ManagerName" readonly="true"/></td>
                    </tr>
                    
                    <tr>
                    <td style="color:white">Status:</td>
                        <td><input path="status" readonly="true"/></td>
                    </tr>
                    
                    <tr>
                        <td style="color:white"> Skills: </font></td>
                        <td>
                            <form:select path="skills"  required="required">

                                <form:options items="${listSkill}" />
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                    <td></td>     
                        <td  align="center"><input type="submit" value="Edit" ></td>
                    </tr>
                </table>
            </form:form>

        </div>
</body>
</html>
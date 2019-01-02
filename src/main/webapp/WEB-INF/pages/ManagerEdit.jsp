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
<body  background="<%=request.getContextPath()%>/resources/images/bg2.jpg">

        <div align="center">
            <h1 style="color: orangered">Edit Employee</h1>
            <h3> <p style="color: green" >${msg}</p></h3>
                <form:form action="byManagerEdit" method="post"
                           modelAttribute="employee" commandName="employee">
                    <form:errors path="*" cssClass="errorblock" element="div" />
                <table>
                    <form:hidden path="id" />
                    <form:hidden path="category" />
                    <form:hidden path="otp" />
                    <tr>
                        <td style="color: yellow">Name:</td>
                        <td><form:input path="name" required="required" readonly="true" /></td>
                        <td><form:errors path="email" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td style="color: yellow">Email:</td>
                        <td><form:input path="email" type="email" required="required" readonly="true" /></td>
                    </tr>
                    <tr>
                        <td style="color: yellow">Address:</font></td>
                        <td><form:input path="address" readonly="true"/></td>
                    </tr>
                    <tr>

                        <td style="color: yellow">Telephone: </font></td>
                        <td><form:input path="telephone" /></td>

                    </tr>

                    <tr>
                        <td style="color: yellow">Password:</td>
                        <td><form:input path="password" type="password"
                                    required="required" /></td>
                    </tr>
                    <tr>
                        <td style="color: yellow">Aadhar No.:</td>
                        <td><form:input path="aadhar" required="required" /></td>
                        <td><form:errors path="aadhar" cssClass="error" /></td>
                    </tr>
                    <tr>
                        <td style="color: yellow">Pan No.:</td>
                        <td><form:input path="pan" required="required" /></td>
                        <td><form:errors path="pan" cssClass="error" /></td>
                    </tr>

                    <tr>
                        <td style="color: yellow">ManagerId</td>
                        <td><form:input path="managerId" readonly="true"/></td>
                    </tr>
                    <tr>
                        <td style="color: yellow">Status</td>
                        <td><form:input path="status" readonly="true" /></td>
                    </tr>


                    <%--<tr>
            <td style="color:white">OTP:</td>
            <td><form:input path="otp" /></td>
        </tr> --%>



                    <tr>
                        <td style="color: yellow">Skills: </font></td>
                        <td><form:select path="skills" required="true">

                                <form:options items="${listSkill}" />
                            </form:select>
                        <td>
                    </tr>

                    <tr>
                        <!--                        <td><input type="submit" value="Send OTP" name="action1" /></td>-->
                        <td colspan="2" align="center"><input type="submit"
                                                              value="Save" name="action2"></td>

                    </tr>
                </table>
            </form:form>
           
    </div>
    
    <div align="right">
        <form action="logout" method="get">
        <input type="submit" value="Logout"> 
        </form></div>
        


</body>
</html>
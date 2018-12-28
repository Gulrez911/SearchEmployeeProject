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
    <body background="<%=request.getContextPath()%>/resources/images/bg2.jpg">


        <div align="center">
            <h1 style="color:orangered">New/Edit Employee</h1>

            <form:form action="saveEmployee" method="post" modelAttribute="employee" commandName="employee">
                <form:errors path = "*" cssClass = "errorblock" element = "div" />
                <table>
                    <form:hidden path="id"/>
                    <tr>
                        <td style="color:white">Name:</td>
                        <td><form:input path="name"  required="required"/></td>
                        <td><form:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color:white"> Email:</td>
                        <td><form:input path="email" type="email"  required="required"/></td>
                        <%--   <tr>
                        <td><input type="submit" value="Send OTP" name="action1"/></td>     
                        <td><form:input path="otp" /></td>
                    </tr> --%>



                    </tr>

                    <tr>
                        <td style="color:white">Address:</font></td>
                        <td><form:input path="address" /></td>
                    </tr>
                    <tr>

                        <td style="color:white"> Telephone: </font></td>
                        <td><form:input path="telephone" /></td>

                    </tr>

                    <tr>
                        <td style="color:white">Password:</td>
                        <td><form:input path="password" type="password" required="required"/></td>
                    </tr>
                    <tr>
                        <td style="color:white">Aadhar No.:</td>
                        <td><form:input path="aadhar"  /></td>
                        <td><form:errors path="aadhar" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color:white">Pan No.:</td>
                        <td><form:input path="pan"  /></td>
                        <td><form:errors path="pan" cssClass="error"/></td>
                    </tr>
                    
                      <tr>
                       <td style="color:white">User Type:</td>
                        <td ><form:select path ="category" name="userTypes">
                    
                     <form:options items = "${userTypes}" />
                     
						</form:select>
						</td>
                    </tr>
                    
                     <tr>
                        <td style="color:white">ManagerId</td>
                        <td><form:input path="managerId" /></td>
                    </tr>
                    
                  

                 


                    <tr>
                        <td style="color:white"> Skills: </font></td>
                        <td>
                            <form:select path="skills" required ="true">

                                <form:options items="${listSkill}" />
                            </form:select>

                        <td>

                    </tr>

                    <tr>
                        <td><input type="submit" value="Submit" name="action1"/></td>     
                        <td colspan="2" align="center"><input type="submit" value="BACK" name="action2"></td>
                    </tr>
                    
                    
            
                </table>
              <tr>
                <div align="right"><td>

                        <a href="logout"><font style="color:white" size="5">LogOut</font></a>
                </div>
            </tr>    
                
                
            </form:form>


        </div>
    </body>
</html>

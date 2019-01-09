<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html> 
    <head>

  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
        <script>
//           $(document).ready(function (){
//               $("input[name$='action1']").click(function (){
//                  alert("You have successfully submited."); 
//               });
//           });
        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Contact</title>
        <style>
            .error { 
                color: red; font-weight: bold; 
            }
        </style>
        <script> 
        /* 
        function formValidation(){
        var name = document.validation.name;
        var add = document.validation.address;
        {
        	if(allLetter(name))
        	{
        		if(alphanumeric(add))
        		{
        		}
        		}
        }
        }
        return false;
        }
        
        
        function allLetter(name)
        { 
        var letters = /^[A-Za-z]+$/;
        if(uname.value.match(letters))
        {
        return true;
        }
        else
        {
        alert('Username must have alphabet characters only');
        name.focus();
        return false;
        }
        } */
        
        /* function alphanumeric(add)
        { 
        var letters = /^[0-9a-zA-Z]+$/;
        if(uadd.value.match(letters))
        {
        return true;
        }
        else
        {
        alert('User address must have alphanumeric characters only');
        add.focus();
        return false;
        }
        }
 */
        
      </script>
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/bg2.jpg">
        <%@include file="header.jsp" %>

        <div align="center">
            <h1 style="color:orangered">New/Edit Employee</h1>

            <form:form action="saveEmployee"  method="post" modelAttribute="employee" commandName="employee">
                <form:errors path = "*" cssClass = "errorblock" element = "div" />
                <table>
                    <form:hidden path="id"/>
                    <tr>
                        <td style="color:Dark blue">Name:</td>

                        <td><form:input path="name"  required="true" pattern="^[A-Za-z\\s]*$"/></td>
                           

                        <td><form:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color:Dark blue"> Email:</td>

                        <td><form:input path="email" type="email"  required="true"/></td>
                        <%--   <tr>
                        <td><input type="submit" value="Send OTP" name="action1"/></td>     
                        <td><form:input path="otp" /></td>
                    </tr> --%>


                    </tr>

                    <tr>
                        <td style="color:Dark blue">Address:</font></td>
                        <td><form:input path="address" required="true"/></td>
                    </tr>
                    <tr>

                        <td style="color:Dark blue"> Telephone: </font></td>

                        <td><form:input path="telephone" required="true" pattern="^[0-9]*$"/></td>


                    </tr>

                    <tr>
                        <td style="color:Dark blue">Password:</td>
                        <td><form:input path="password" type="password" required="true"/></td>
                    </tr>
                    <tr>
                        <td style="color:Dark blue">Aadhar No.:</td>
                        <td><form:input path="aadhar"  /></td>
                        <td><form:errors path="aadhar" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td style="color:Dark blue">Pan No.:</td>
                        <td><form:input path="pan"  /></td>
                        <td><form:errors path="pan" cssClass="error"/></td>
                    </tr>

                    <tr>
                        <td style="color:Dark blue">User Type:</td>


                       

                        <td ><form:select path ="category" name="userTypes" required="true">
 <form:options items = "${userTypes}" />

                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td style="color:Dark blue">ManagerId</td>

                        <td><form:input path="managerId" required="true" pattern="^[0-9]*$"/></td>

                    </tr>

                    <tr>
                        <td style="color:Dark blue"> Skills: </font></td>
                        <td>
                            <form:select path="skills" required ="true">

                                <form:options items="${listSkill}" />
                            </form:select>

                        <td>

                    </tr>

                    <tr>
                        <td><input type="submit" value="BACK" name="action2"></td>
                        <td><input type="submit" value="Submit" name="action1" id="submit1"/></td>    
                    </tr>     
                </table>     
            </form:form>
        </div>

    </body>
</html>

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
       
        
        
       
        
        
 <!-- 
 <script type="text/javascript">
 function AadharValidate() {
     var aadhar = document.getElementById("txtAadhar").value;
     var adharcardTwelveDigit = /^\d{12}$/;
     var adharSixteenDigit = /^\d{16}$/;
     if (aadhar != '') {
         if (aadhar.match(adharcardTwelveDigit)) {
             return true;
         }
         else if (aadhar.match(adharSixteenDigit)) {
             return true;
         }
         else {
             alert("Enter valid Aadhar Number");
             return false;
         }
     }
 }
</script> -->

<style>
/* Style the container for inputs */
.container {
  background-color: #f1f1f1;
  padding: 20px;
}


/* The message box is shown when the user clicks on the password field */
#message {
  display:none;
  background: #f1f1f1;
  color: #000;
  position: relative;
  padding: 20px;
  margin-top: 10px;
}

#message p {
  padding: 10px 35px;
  font-size: 18px;
}
/* Add a green text color and a checkmark when the requirements are right */
.valid {
  color: green;
}

.valid:before {
  position: relative;
  left: -35px;
  content: "&#10004;";
}

/* Add a red text color and an "x" icon when the requirements are wrong */
.invalid {
  color: red;
}

.invalid:before {
  position: relative;
  left: -35px;
  content: "&#10006;";
}
</style>

<script>
var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

//When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}
         

/ When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) { 
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
}
//Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) { 
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) { 
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
//Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>




        
     
    </head>
    <body background="<%=request.getContextPath()%>/resources/images/bg2.jpg">
        <%@include file="header.jsp" %>

        <div align="center">
            <h1 style="color:orangered">New/Edit Employee</h1>

            <form:form action="saveEmployee"  method="post" modelAttribute="employee" commandName="employee" onclick="AadharValidate()">
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
                        <td><form:input path="password" type="password" id="psw" name="psw" 
                        pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
                        title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required="true"/></td>
                    </tr>
                    <tr>
                        <td style="color:Dark blue">Aadhar No.:</td>
                        <td><form:input path="aadhar"  id="txtAadhar" /></td>
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
        
<div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div>

    </body>
</html>

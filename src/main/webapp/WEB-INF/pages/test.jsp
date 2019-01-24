<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/JS/jquery.js"></script>
        <style>
            table {
                border-collapse: collapse;
            }
            th, td {
                text-align: left;
                padding: 8px;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2
            }
            th {
                background-color: #4CAF50;
                color: white;
            }

        </style>
        <script>
            $(document).ready(function () {
            	  alert("on load");
                $('#skill_Form').submit(function (event) {
                    var data = {}
                    data["skill_Id"] = $("#skill_Id").val();
                    data["skill_name"] = $('#skill_name').val();
                    $.ajax({
                        url: "SaveSkillAjax",
                        data: JSON.stringify(data),
                        type: "POST",
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader("Accept", "application/json");
                            xhr.setRequestHeader("Content-Type", "application/json");
                        },
                        success: function (skill) {
                            load();
                            refresh();
                        }
                    });
                    event.preventDefault();
                });
            });
        </script>
    </head>

    <body
        background="<%=request.getContextPath()%>/resources/images/bg2.jpg"  onload="load()">

        <div align="center">
            <h1 style="color:red">Skills Tracker: Add Skill Page</h1>
            <div style="color: red">${error}</div> 

            <form:form id="skill_Form" action="SaveSkillAjax" method="post" modelAttribute="skill"
                       commandName="skill">
                <table>

                    <form:hidden path="skill_Id" id="skill_Id"/>
                    <tr>
                        <td style="color: Dark blue">Name:</td>
                        <td><form:input path="skill_name" name="skill_name"
                                    id="skill_name"  required="true"/> </td>


                    <br>
                    <td colspan="2" align="center"><input type="submit"
                                                          value="Add" ></td>
                    </tr>
                </table>
            </form:form>
            <input id="myInput" type="text" placeholder="Search Skill Here.."  /><br></br> 
            <table id="table1" border=1>
                <th> Name </th><th> Edit </th> <th> Delete</th> 

            </table>
            <p></p> 
        </div>
    </body>
</html>

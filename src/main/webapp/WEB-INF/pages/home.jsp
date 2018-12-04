<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%-- <%@ page import="com.kgate.service.SkillService;" %> --%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management Screen</title>
    </head>


    <body background="<%=request.getContextPath()%>/resources/images/wp2596947.jpg">

        
        <div align="center">

            <h1>Employee List</h1>
             <center><a href="/SpringMVCHibernateCRUD/downloadPDF"><font style="color:white" size="5">Download PDF</font></a><br></center>
          
         

            <h1 style="color:white">Employee List</h1>

            <form action="<s:url value="/search_employeelist"/>">
           
                <input type="text" name="freeText" placeholder="Enter Text To Search" value="${param.freeText}"/>
                
                <button>Find</button>
            </form>
            <br>
            <form action="<s:url value="/search_employeelist_skill1"/>">
            <td>    <input type="text" name="skillSearch" placeholder="Enter Skill To Search" value="${param.skillSearch}"/>
                <button>Find</button>
            </form>
         
            <br>
            <p>${error}</p>
            <table border="1">

                <th style="color:red">Name</th>
                <th style="color:red">Email</th>
                <th style="color:red">Address</th>
                <th style="color:red">Telephone</th>
                <th style="color:red">Action</th>

                <c:forEach var="employee" items="${listEmployee}">
                    <tr style="color:white">

                        <td>${employee.name}</td>
                        <td>${employee.email}</td>
                        <td>${employee.address}</td>
                        <td>${employee.telephone}</td>
                        <td ><a href="editEmployee?id=${employee.id}" style="color:greenyellow">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="deleteEmployee?id=${employee.id}" style="color:greenyellow">Delete</a></td>

                    </tr>
                </c:forEach>
            </table>
            <h4>
                New Employee Register <a href="newEmployee">here</a>
            </h4>
        </div>
    </body>
</html>
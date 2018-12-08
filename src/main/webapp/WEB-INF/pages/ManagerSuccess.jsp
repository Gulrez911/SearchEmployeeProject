<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<%=request.getContextPath()%>/resources/images/wp2596947.jpg">
<!-- <form:form action="/" method="post" > -->
 <table border="1">

                <th style="color:red">Name</th>
                <th style="color:red">Email</th>
                <th style="color:red">Address</th>
                <th style="color:red">Telephone</th>
                <th style="color:red">status</th>
               
                

                <c:forEach var="employee" items="${elist}">
                    <tr style="color:white">

                        <td>${employee.name}</td>
                        <td>${employee.email}</td>
                        <td>${employee.address}</td>
                        <td>${employee.telephone}</td>
                         <td>${employee.category}</td>
                      

                    </tr>
                </c:forEach>
                <tr>
                
                <td><input type="submit" value="Back"></td>
                </tr>
            </table>
           <!--  </form:form> -->
</body>
</html>
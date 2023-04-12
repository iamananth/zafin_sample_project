<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.zafin.servletcrud.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
	 	<th>Student ID</th>
	 	<th>First Name</th>
	 	<th>Last Name</th>
	 	<th>Email</th>
	 </tr>
	 <c:forEach var="tempstudent" items="${STUDENT_LIST}">
	  	<tr> 
	  		<td>${tempstudent.studId}</td>
	  		<td>${tempstudent.firstName}</td>
	  		<td>${tempstudent.lastName}</td>
	  		<td>${tempstudent.email}dddd</td>
	  	</tr>
	 </c:forEach>
</table>

</body>
</html>
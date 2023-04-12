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
<form> 
<button type="submit" formaction="add-student.jsp"> Add</button>
</form>
<br>
<table border="1">
	<tr>
	 	<th>Student ID</th>
	 	<th>First Name</th>
	 	<th>Last Name</th>
	 	<th>Email</th>
	 	<th>Action</th>
	 </tr>
	 <c:forEach var="tempstudent" items="${STUDENT_LIST}">
	  	
	  	
	  	<c:url var="deletetemplink" value="StudentControllerServlet"> 
	  		<c:param name="command" value="DELETE"></c:param>
	  		<c:param name="studentId" value="${tempstudent.studId}"></c:param>
	  	</c:url>
	  	<c:url var="loadtemplink" value="StudentControllerServlet"> 
	  		<c:param name="command" value="LOAD"></c:param>
	  		<c:param name="studentId" value="${tempstudent.studId}"></c:param>
	  	</c:url>
	  	
	  	
	  	
	  	<tr> 
	  		<td>${tempstudent.studId}</td>
	  		<td>${tempstudent.firstName}</td>
	  		<td>${tempstudent.lastName}</td>
	  		<td>${tempstudent.email}</td>
	  		<td> <a href="${loadtemplink}" >Update</a> 
	  		<a href="${deletetemplink}" >Delete</a></td>
	  	</tr>
	 </c:forEach>
</table>

</body>
</html>
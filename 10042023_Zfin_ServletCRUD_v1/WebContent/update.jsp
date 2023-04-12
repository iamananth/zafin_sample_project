<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.zafin.servletcrud.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:url var="updatetemplink" value="StudentControllerServlet">
		<c:param name="command" value="UPDATE"></c:param>
		<c:param name="fName" value="${fname }"></c:param>
		<c:param name="lName" value="${lname }"></c:param>
		<c:param name="eMail" value="${email}"></c:param>
		<c:param name="id" value="${DETAILS.studId}"></c:param>
	</c:url>
 --%>
	<p>Update Details</p>

	<form action="StudentControllerServlet" method="get">
	<input type="hidden" name="command" value="UPDATE"/> 
	<input type="hidden" name="id" value="${DETAILS.studId}"/> 
		<label for="fname">First name:</label><br> <input type="text"
			id="fname" name="fname" value="${DETAILS.firstName}"><br>
		<label for="lname">Last name:</label><br> <input type="text"
			id="lname" name="lname" value="${DETAILS.lastName}"><br>
		<label for="email"> Email:</label><br> <input type="text"
			id="email" name="email" value="${DETAILS.email}"><br>
		<button type="submit">UPDATE</button>
			 
		

	</form>
</body>
</html>
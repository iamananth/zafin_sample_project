<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Enter Details</p>
	<form action="StudentControllerServlet" method="post">
		<label for="fname">First name:</label><br> <input type="text"id="fname" name="fname"><br> 
		<label for="lname">Last name:</label><br> <input type="text" id="lname" name="lname"><br>
		<label for="email"> Email:</label><br> <input type="text" id="email" name="email"><br>
		<button >Submit </button>
	</form>
</body>
</html>

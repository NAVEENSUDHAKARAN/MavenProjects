<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
	<%
		String mail = request.getParameter("mail");
	%>
	<form action="UpdateUser">
		<input type="text" name="mailid" value="<%= mail %>" >
		<input type="text" name="nameToUpdate" placeholder="Enter the name to update" >
		<input type="password" name="passwordToUpdate" placeholder="Enter Password to update" >
		<input type="submit" value="ok" >
	</form>	
</body>
</html>
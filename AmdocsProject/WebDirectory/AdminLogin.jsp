<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
</head>
<body  style="text-align: center; background-color : #eebb99">
	<form action="adminLogin" method="post" style="margin-top: 250px">
	Admin Name <input type="text" name = "admin" required/> <br/><br/>
	Password <input type="password" name = "password" required/> <br/><br/>
	<input type="submit" value="Login as Admin"/>	
	</form>
</body>
</html>
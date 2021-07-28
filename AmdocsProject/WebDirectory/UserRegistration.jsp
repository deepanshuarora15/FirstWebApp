<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action ="UserRegister" method="post">
		Name <input type="text" name="name" required/><br/>
		Email <input type="email" name="email" required/><br/>
		Password <input type="password" name="password" required/><br/>
		Phone <input type="number" name="phone" required/><br/>
		Address <input type="text" name="address" required/><br/>
		Reg. Date <input type="text" name="regdate" required/><br/>
		Upload Photo <input type="text" name="photoURL" required/><br/>
		
		<input type="submit" value="Register"/>
	</form>
</body>
</html>
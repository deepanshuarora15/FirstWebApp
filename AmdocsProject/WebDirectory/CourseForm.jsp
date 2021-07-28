<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addcourse" method="get">
	Course Name <input type="text" name="courseName" required/><br/>
	Course Description <input type="text" name="courseDescription" required/><br/>
	Course Resources <input type="text" name="courseResources" required/><br/>
	Course Fees <input type="text" name="courseFees" required/><br/>
	<input type="submit" value="Submit"/>
</form>
	
</body>
</html>
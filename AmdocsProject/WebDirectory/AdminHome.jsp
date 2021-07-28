<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body style="text-align: center; padding-top: 100px; background-color : #eebb99">
<a href="logout" style="position: absolute; right:50px"><input type="submit" value="Logout"/></a>
<% 	
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0"); 
	if(session.getAttribute("admin")==null){
		response.sendRedirect("AdminLogin.jsp");
		return;
	}
	out.println("<img src=\"https://bit.ly/3f1tbjy\" width=\"200\" height=\"200\" style=\"border-radius: 100px;\"/><br/>");
%>
	Welcome Admin<br/><br/>
	<a href="CourseForm.jsp">Add New Course</a><br/>
	<a href="AllCourses.jsp">View All Courses</a><br/>
	<a href="AllUsers.jsp">View All Users</a><br/>
	<a href="AllEnrollments.jsp">View User Enrollments</a><br/>
</body>
</html>
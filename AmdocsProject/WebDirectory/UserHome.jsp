<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.user.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
</head>
<body style="text-align: center; padding-top: 100px; background-color : #eebb99">
<a href="logout" style="position: absolute; right:50px"><input type="submit" value="Logout"/></a>

<% 	
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
	response.setHeader("Pragma", "no-cache"); 
	response.setHeader("Expires", "0");
	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
		return;
	}
	out.println("<img src=\"https://bit.ly/3f1tbjy\" width=\"200\" height=\"200\" style=\"border-radius: 100px;\"/><br/>");
	out.println("Welcome " + ((User)session.getValue("user")).getName());
%>
	<br/><br/>
	<a href="Enroll.jsp">View & Enroll Courses</a><br/>
	<a href="FeedbackForm.jsp">New Feedback & History</a><br/>
	<a href="ContactForm.jsp">Contact Form & History</a><br/>	

</body>
</html>
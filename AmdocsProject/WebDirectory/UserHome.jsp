<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.user.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 	
	out.println("Welcome " + ((User)session.getValue("user")).getName());
	out.println("<img src=\"https://bit.ly/3zB3P3L\" width=\"200\" height=\"200\" />");
%>
	<br/>
	<a href="Enroll.jsp">View & Enroll Courses</a><br/>
	<a href="FeedbackForm.jsp">New Feedback & History</a><br/>
	<a href="ContactForm.jsp">Contact Form & History</a><br/>	

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center;">
<% 	
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
	response.setHeader("Pragma", "no-cache"); 
	response.setHeader("Expires", "0");
	if(session.getAttribute("admin")==null){
		response.sendRedirect("AdminLogin.jsp");
		return;
	}
%>
<form action="addcourse" method="get" style="margin-top:200px">
	Course Name <input type="text" name="courseName" required/><br/><br/>
	Course Description <input type="text" name="courseDescription" required/><br/><br/>
	Course Resources <input type="text" name="courseResources" required/><br/><br/>
	Course Fees <input type="text" name="courseFees" required/><br/><br/>
	<input type="submit" value="Submit"/>
</form>
	
</body>
</html>
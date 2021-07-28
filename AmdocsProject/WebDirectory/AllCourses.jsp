<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.course.model.Course, projectDAO.course.dao.CourseDAO, projectDAO.course.dao.impl.CourseDAOImpl,
    java.util.List
    "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Courses</title>
<style>

 tr:nth-child(even) {
            background-color: Lightgreen;
}
</style>
</head>

<body style="text-align:center; padding-top:100px">
<% 	
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); // for http 1.1. & above
	response.setHeader("Pragma", "no-cache"); // Http 1.0
	response.setHeader("Expires", "0"); // Proxies
	if(session.getAttribute("admin")==null){
		response.sendRedirect("AdminLogin.jsp");
		return;
	}
%>
All courses<br/><br/>
<table width="100%" border="1">
    <thead style="background-color : cyan">
    <tr>
        <td>Course ID</td>
        <td>Course Name</td>
        <td>Course Resource</td>
        <td>Course Description</td>
        <td>Course Fee</td>
    </tr>
    </thead>
    <tbody>
    <%
    	CourseDAO ob = new CourseDAOImpl();
    	List<Course> courses = ob.getAllCourses();
    	for(Course c: courses){

            out.print(String.format("<tr>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +                                      
                                    "</tr>",
                    c.getCourse_id(), c.getC_name(), c.getC_resource(), c.getC_desp(), c.getC_fees())
            		);
        }

        out.flush();
    %>
    </tbody>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.enrollment.model.Enrollment, projectDAO.enrollment.dao.EnrollmentDAO,
    java.util.List, projectDAO.enrollment.dao.impl.EnrollmentDAOImpl
    "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

 tr:nth-child(even) {
            background-color: Lightgreen;
}
</style>
</head>
<body style="text-align:center; padding-top:100px; background-color : #eebb99"">
<% 	
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
	response.setHeader("Pragma", "no-cache"); 
	response.setHeader("Expires", "0"); 
	if(session.getAttribute("admin")==null){
		response.sendRedirect("AdminLogin.jsp");
		return;
	}
%>
<a href="logout" style="position: absolute; right:50px"><input type="submit" value="Logout"/></a>

All Enrollments<br/><br/>
	
	<table width="100%" border="1">
    <thead style="background-color : cyan">
    <tr>
    	<td>Enroll ID</td>
        <td>User ID</td>
        <td>Name</td>
        <td>Course ID</td>
        <td>Course Name</td>
        <td>Course Description</td>
        <td>Course Fees</td>
        <td>Course Resources</td>
    </tr>
    </thead>
    <tbody>
    <%
    	EnrollmentDAO ob = new EnrollmentDAOImpl();
    	List<Enrollment> enrollments = ob.getAllEnrollments();
    	for(Enrollment c: enrollments){
            out.print(String.format("<tr>" +
                                        "<td>%d</td>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" + 
                                        "<td>%s</td>" + 
                                        "<td>%s</td>" + 
                                    "</tr>",
                   c.getEnroll_id() ,c.getUser_id(), c.getName(), c.getCourse_id(), c.getC_name(), c.getC_desp(), c.getC_fees(), c.getC_resource())
            		);
        }

        out.flush();
    %>
    </tbody>
</table>
</body>
</html>
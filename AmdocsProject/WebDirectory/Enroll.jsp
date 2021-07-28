<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.enrollment.model.Enrollment, projectDAO.enrollment.dao.EnrollmentDAO,
    java.util.List, projectDAO.enrollment.dao.impl.EnrollmentDAOImpl, projectDAO.user.model.User,
    projectDAO.course.model.Course, projectDAO.course.dao.CourseDAO, projectDAO.course.dao.impl.CourseDAOImpl
    "
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
My Enrollments
<table width="60%" border="1">
    <thead>
    <tr>
    	<td>Enrollment ID</td>
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
    	Long id = ((User)session.getAttribute("user")).getUser_id();
    	List<Enrollment> enrollments = ob.getEnrollmentById(id);
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
                    c.getEnroll_id(), c.getUser_id(), c.getName(), c.getCourse_id(), c.getC_name(), c.getC_desp(), c.getC_fees(), c.getC_resource())
            		);
        }
        out.flush();
    %>
    </tbody>
</table>
Enroll More below:
<form action="enrolluser">
<table width="60%" border="1">
    <thead>
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
    	CourseDAO obj = new CourseDAOImpl();
    	List<Course> courses = obj.getAllCourses();
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
Enter the course ID you want to enroll<input type="number" name="courseId" required/>
<input type="submit" value = "Submit"/>
</form>
</body>
</html>
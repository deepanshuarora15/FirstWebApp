<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.user.model.User, 
    projectDAO.feedback.dao.FeedbackDAO, 
    projectDAO.feedback.dao.impl.FeedbackDAOImpl,
    projectDAO.feedback.model.Feedback,
    java.util.List
    "
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Feedback</title>
<style>

 tr:nth-child(even) {
            background-color: Lightgreen;
}

</style>
</head>
<body style="text-align: center">
<%
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
	response.setHeader("Pragma", "no-cache"); 
	response.setHeader("Expires", "0");
	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
		return;
	}
%>
	<form action="feed" method="get" style="margin-bottom : 100px">
	Name <input type="text" name="name" readonly value="<%= ((User)session.getAttribute("user")).getName() %>" /><br/>
	User ID  <input type="number" name="userid" readonly value="<%= ((User)session.getAttribute("user")).getUser_id() %>"/><br/>
	Email <input type="text" name="email" readonly value="<%= ((User)session.getAttribute("user")).getEmail() %>"/><br/>
	Feedback <input type="text" name="feedback" required/><br/>
	<input type="submit" value="Submit"/> 
	</form>
	History<br/>
	
	<table width="100%" border="1">
    <thead style="background-color: cyan">
    <tr>
        <td>User ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Feedback ID</td>
        <td>Feedback</td>
    </tr>
    </thead>
    <tbody>
    <%
    	FeedbackDAO ob = new FeedbackDAOImpl();
		Long id = ((User)session.getAttribute("user")).getUser_id();
    	List<Feedback> feedbackList = ob.getFeedbackByUserId(id);
    	for(Feedback c: feedbackList){

            out.print(String.format("<tr>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +                                 
                                    "</tr>",
                    c.getUser_id(), c.getName(), c.getEmail(), c.getF_id(), c.getFeedback())
            		);
        }

        out.flush();
    %>
    </tbody>
</table>
</body>
</html>
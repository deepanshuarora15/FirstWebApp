<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.user.model.User, projectDAO.user.dao.UserDAO,
     projectDAO.user.dao.impl.UserDAOImpl, java.util.List
    "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
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

All Users <br/><br/>
<table width="100%" border="1">
    <thead style="background-color : cyan">
    <tr>
        <td>User ID</td>
        <td>Name</td>
        <td>Phone Number</td>
        <td>Email</td>
        <td>Address</td>
        <td>Reg. Date</td>
        <td>Photo URL</td> 
    </tr>
    </thead>
    <tbody>
    <%
    	UserDAO ob = new UserDAOImpl();
    	List<User> users = ob.findAll();
    	for(User c: users){

            out.print(String.format("<tr>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +
                                    "</tr>",
                    c.getUser_id(), c.getName(), c.getPhone_no(), c.getEmail(), c.getAddress(), c.getReg_date(), c.getUpload_photo())
            		);
        }

        out.flush();
    %>
    </tbody>
</table>
</body>
</html>
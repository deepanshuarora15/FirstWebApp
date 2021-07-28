<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.user.model.User, projectDAO.contact.dao.ContactDAO, projectDAO.contact.dao.impl.ContactDAOImpl,
    java.util.List, java.util.ArrayList, projectDAO.contact.model.Contact" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fill Contact Form</title>
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
	<form action="contact" method="get" style="margin-bottom : 100px">
	USER ID <input type="number" name="userid" value="<%= ((User)session.getAttribute("user")).getUser_id() %>" readonly="readonly" /><br/>
	NAME <input type="text" name="name" readonly value="<%= ((User)session.getAttribute("user")).getName() %>"/><br/>
	E-MAIL <input type="email" name="email" readonly value="<%= ((User)session.getAttribute("user")).getEmail() %>"/><br/>
	PHONE <input type="number" name="phone" readonly value="<%= ((User)session.getAttribute("user")).getPhone_no() %>"/><br/>
	MESSAGE <input type="text" name="message" required /><br/>
	<input type="submit" value="Submit"/> <br/>
	</form>
	History<br/>
	
	<table width="100%" border="1">
    <thead style="background-color: cyan">
    <tr>
    	<td>Contact ID</td>
        <td>User ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Phone Number</td>
        <td>Message</td>
    </tr>
    </thead>
    <tbody>
    <%
    	ContactDAO ob = new ContactDAOImpl();
		Long id = ((User)session.getAttribute("user")).getUser_id();
    	List<Contact> contacts = ob.viewContactByUserId(id);
    	for(Contact c: contacts){

            out.print(String.format("<tr>" +
                                        "<td>%d</td>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                    "</tr>",
                                    c.getContact_id(), c.getUser_id(), c.getName(), c.getEmail(), c.getPhone_no(), c.getMessage())
            		);
        }

        out.flush();
    %>
    </tbody>
</table>
</body>
</html>
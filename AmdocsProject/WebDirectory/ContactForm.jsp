<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.user.model.User, projectDAO.contact.dao.ContactDAO, projectDAO.contact.dao.impl.ContactDAOImpl,
    java.util.List, java.util.ArrayList, projectDAO.contact.model.Contact" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="contact" method="get">
	USER ID <input type="number" name="userid" value="<%= ((User)session.getAttribute("user")).getUser_id() %>" readonly="readonly" /><br/>
	NAME <input type="text" name="name" readonly="readonly" value="<%= ((User)session.getAttribute("user")).getName() %>"/><br/>
	E-MAIL <input type="email" name="email" readonly="readonly" value="<%= ((User)session.getAttribute("user")).getEmail() %>"/><br/>
	PHONE <input type="number" name="phone" readonly="readonly" value="<%= ((User)session.getAttribute("user")).getPhone_no() %>"/><br/>
	MESSAGE <input type="text" name="message" required /><br/>
	<input type="submit" value="Submit"/> <br/>
	</form>
	History<br/>
	
	<table width="60%" border="1">
    <thead>
    <tr>
        <td>User ID</td>
        <td>Name</td>
        <td>Email</td>
        <td>Phone Number</td>
        <td>Message</td>
        <td>Contact ID</td>
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
                                        "<td>%s</td>" +
                                        "<td>%s</td>" +
                                        "<td>%d</td>" +
                                        "<td>%s</td>" +
                                        "<td>%d</td>" +
                                    "</tr>",
                    c.getUser_id(), c.getName(), c.getEmail(), c.getPhone_no(), c.getMessage(), c.getContact_id())
            		);
        }

        out.flush();
    %>
    </tbody>
</table>
</body>
</html>
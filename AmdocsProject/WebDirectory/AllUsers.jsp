<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projectDAO.user.model.User, projectDAO.user.dao.UserDAO,
     projectDAO.user.dao.impl.UserDAOImpl, java.util.List
    "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
All Users
<table width="60%" border="1">
    <thead>
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
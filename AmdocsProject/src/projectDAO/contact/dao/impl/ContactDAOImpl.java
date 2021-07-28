package projectDAO.contact.dao.impl;

import projectDAO.contact.dao.ContactDAO;
import projectDAO.contact.model.Contact;
import projectDAO.user.model.User;
import projectDAO.contact.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ContactDAOImpl implements ContactDAO {

	Connection conn = DBUtil.getConnection();

	@Override
	public List<Contact> viewContactByUserId(Long id) {
		List<Contact> contacts = new ArrayList<>();
		String query = "select * from contact where user_id = ? order by contact_id desc";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Long phone_no = rs.getLong("phone_no");
				String message = rs.getString("message");
				Long contact_id = rs.getLong("contact_id");
				Contact c = new Contact(user_id, name, email, phone_no, message, contact_id);
				contacts.add(c);
			}
			return contacts;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Contact> viewAllContacts() {
		return null;
	}

	@Override
	public boolean connect(Long user_id, String name, String email, Long phone_no, String message) {
		String query = "insert into contact(user_id, name, email, phone_no, message) values(?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, user_id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setLong(4, phone_no);
			ps.setString(5, message);
			int count = ps.executeUpdate();
			if (count>=1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

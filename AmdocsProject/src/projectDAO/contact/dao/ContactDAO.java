package projectDAO.contact.dao;

import projectDAO.contact.model.Contact;

import java.util.List;

public interface ContactDAO {

//	List<User> findAll();
//	boolean addUser(User user);
//	User getUserById(Long id);
//	boolean deleteUser(Long id);
//	boolean updateUser(User user);

	boolean connect(Long user_id, String name, String email, Long phone_no, String message);
	List<Contact> viewContactByUserId(Long id);
	List<Contact> viewAllContacts();
}

package projectDAO.user.dao;

import projectDAO.user.model.User;
import java.util.List;

public interface UserDAO {

	List<User> findAll();
	boolean addUser(User user);
	User getUserById(Long id);
	boolean deleteUser(Long id);
	boolean updateUser(User user);
	User userLogin(String name, String password);
}

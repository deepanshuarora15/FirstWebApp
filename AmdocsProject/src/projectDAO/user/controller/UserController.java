package projectDAO.user.controller;

import projectDAO.user.dao.UserDAO;
import projectDAO.user.dao.impl.UserDAOImpl;
import projectDAO.user.model.User;

import java.util.List;

public class UserController {

	public static void main(String[] args) {
		UserDAO dao = (UserDAO) new UserDAOImpl();
		User singleuser = dao.getUserById(101L);
		System.out.println("single user on search by id is "+singleuser.toString());
		System.out.println();
		User userToBeUpdated = new User(104L, "aishwarya", 9256279162L, "iswarya@gmail.com", "nellore", "22-feb-2021", "iswarya", "img3.jpg");
		boolean  userUpdated= dao.updateUser(userToBeUpdated);
		System.out.println("whether user updated? " + userUpdated);
		System.out.println();

//		boolean status = dao.addUser(userToBeUpdated);
//		if(status)
//			System.out.println("User Added Successfully");

		boolean result = dao.deleteUser(108L);
		if(result)
			System.out.println("User with Id "+108+ " is deleted successfully");
		else
			System.out.println("No User available");
		List<User> list = dao.findAll();
		list.forEach(System.out::println);
	}

}

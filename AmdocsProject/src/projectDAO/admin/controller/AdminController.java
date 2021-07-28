package projectDAO.admin.controller;

import projectDAO.admin.dao.AdminDAO;
import projectDAO.admin.dao.impl.AdminDAOImpl;


public class AdminController {

	public static void main(String[] args) {
		AdminDAO ob = new AdminDAOImpl();
		//Admin admin = ob.getAdminById(4L);
		//System.out.println(admin.toString());
	}

}

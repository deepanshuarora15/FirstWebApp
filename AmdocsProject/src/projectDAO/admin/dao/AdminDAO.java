package projectDAO.admin.dao;

import projectDAO.admin.model.Admin;

import java.util.List;

public interface AdminDAO {
	Admin adminLogin(String adminName, String password);
}

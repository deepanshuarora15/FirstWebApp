package projectDAO.admin.dao.impl;

import projectDAO.admin.dao.AdminDAO;
import projectDAO.admin.model.Admin;
import projectDAO.admin.util.DBUtil;

import java.sql.*;



public class AdminDAOImpl implements AdminDAO {

	Connection conn = DBUtil.getConnection();

	@Override
	public Admin adminLogin(String adminname, String pass) {
		String query = "select * from admin where name = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, adminname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Long admin_id = rs.getLong("admin_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Admin admin = new Admin(admin_id, name, email, password);
				return admin;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}


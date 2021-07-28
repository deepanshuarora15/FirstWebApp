package projectDAO.user.dao.impl;

import projectDAO.user.dao.UserDAO;
import projectDAO.user.model.User;
import projectDAO.user.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class UserDAOImpl implements UserDAO {

	Connection conn = DBUtil.getConnection();

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		String sql = "select * from user";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				Long phone_no = rs.getLong("phone_no");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String reg_date = rs.getString("reg_date");
				String password = rs.getString("password");
				String upload_photo = rs.getString("upload_photo");
				User user = new User(user_id, name, phone_no, email, address, reg_date, password, upload_photo);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {

		String query = "insert into user(name, phone_no, email, address, reg_date, password, upload_photo) values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setLong(2, user.getPhone_no());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getReg_date());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getUpload_photo());
			int count = ps.executeUpdate();
			if (count>=1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public User getUserById(Long id) {
		String query = "select * from user where user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				Long phone_no = rs.getLong("phone_no");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String reg_date = rs.getString("reg_date");
				String password = rs.getString("password");
				String upload_photo = rs.getString("upload_photo");
				User user = new User(user_id, name, phone_no, email, address, reg_date, password, upload_photo);
				return user;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteUser(Long id) {
		String query = "delete from user where user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1,id);
			int count = ps.executeUpdate();
			if (count>0)
				return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		Long user_id = user.getUser_id();
		String name = user.getName();
		Long phone_no = user.getPhone_no();
		String email = user.getEmail();
		String address = user.getAddress();
		String reg_date = user.getReg_date();
		String password = user.getPassword();
		String upload_photo = user.getUpload_photo();
		String query ="update user set name=?, phone_no=?, email=?, address=?, reg_date=?, password=?, upload_photo=? where user_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setLong(2, phone_no);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, reg_date);
			ps.setString(6, password);
			ps.setString(7, upload_photo);
			ps.setLong(8, user_id);
			int count = ps.executeUpdate();
			if (count>=1)
				return true;
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User userLogin(String name, String password) {
		String query = "select * from user where name = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Long user_id = rs.getLong("user_id");
				Long phone_no = rs.getLong("phone_no");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String reg_date = rs.getString("reg_date");
				String upload_photo = rs.getString("upload_photo");
				User user = new User(user_id, name, phone_no, email, address, reg_date, password, upload_photo);
				return user;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}

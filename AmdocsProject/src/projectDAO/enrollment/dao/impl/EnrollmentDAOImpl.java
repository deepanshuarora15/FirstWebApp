package projectDAO.enrollment.dao.impl;

import projectDAO.enrollment.dao.EnrollmentDAO;
import projectDAO.enrollment.model.Enrollment;
import projectDAO.enrollment.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EnrollmentDAOImpl implements EnrollmentDAO {

	Connection conn = DBUtil.getConnection();

	public List<Enrollment> getAllEnrollments() {
		String query = "select * from enrollment";
		List<Enrollment> enrollments = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Long enroll_id = rs.getLong("enroll_id");
				Long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				Long course_id = rs.getLong("course_id");
				String c_name = rs.getString("c_name");
				String c_desp = rs.getString("c_desp");
				String c_fees = rs.getString("c_fees");
				String c_resource = rs.getString("c_resource");
				Enrollment en = new Enrollment(enroll_id, user_id, name, course_id, c_name, c_desp, c_fees, c_resource);
				enrollments.add(en);
			}
			return enrollments;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addEnrollment(Long user_id, String name, Long course_id, String c_name, String c_desp, String c_fees, String c_resource) {
		String query = "insert into enrollment(user_id, name, course_id, c_name, c_desp, c_fees, c_resource) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, user_id);
			ps.setString(2, name);
			ps.setLong(3, course_id);
			ps.setString(4, c_name);
			ps.setString(5, c_desp);
			ps.setString(6, c_fees);
			ps.setString(7, c_resource);
			int count = ps.executeUpdate();
			if (count>=1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Enrollment> getEnrollmentById(Long id) {
		String query = "select * from enrollment where user_id = ?";
		List<Enrollment> enrollments = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Long enroll_id = rs.getLong("enroll_id");
				Long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				Long course_id = rs.getLong("course_id");
				String c_name = rs.getString("c_name");
				String c_desp = rs.getString("c_desp");
				String c_fees = rs.getString("c_fees");
				String c_resource = rs.getString("c_resource");
				Enrollment en = new Enrollment(enroll_id, user_id, name, course_id, c_name, c_desp, c_fees, c_resource);
				enrollments.add(en);
			}
			return enrollments;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean getEnrollmentByUserandCourseID(Long userId, Long courseId) {
		// TODO Auto-generated method stub
		String query = "select * from enrollment where user_id = ? and course_id = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, userId);
			ps.setLong(2, courseId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}




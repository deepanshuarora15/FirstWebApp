package projectDAO.course.dao.impl;

import projectDAO.course.dao.CourseDAO;
import projectDAO.course.model.Course;
import projectDAO.course.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CourseDAOImpl implements CourseDAO {

	Connection conn = DBUtil.getConnection();

	@Override
	public boolean addCourse(String coursename, String coursedescription , String c_fees, String c_resource) {
		String query = "insert into course(c_name, c_desp, c_fees, c_resource) values(?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, coursename);
			ps.setString(2, coursedescription);
			ps.setString(3, c_fees);
			ps.setString(4, c_resource);
			int count = ps.executeUpdate();
			if (count>=1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Course getCourse(Long courseId) {
		String sql = "select * from course where course_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, courseId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Long course_id = rs.getLong("course_id");
				String c_name = rs.getString("c_name");
				String c_desp = rs.getString("c_desp");
				String c_fees = rs.getString("c_fees");
				String c_resource = rs.getString("c_resource");
				return new Course(course_id, c_name, c_desp,  c_fees, c_resource);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		String sql = "select * from course";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long course_id = rs.getLong("course_id");
				String c_name = rs.getString("c_name");
				String c_desp = rs.getString("c_desp");
				String c_fees = rs.getString("c_fees");
				String c_resource = rs.getString("c_resource");
				Course course = new Course(course_id, c_name, c_desp,  c_fees, c_resource);
				courses.add(course);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

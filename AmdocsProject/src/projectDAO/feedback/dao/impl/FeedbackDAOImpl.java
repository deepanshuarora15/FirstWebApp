package projectDAO.feedback.dao.impl;

import projectDAO.feedback.dao.FeedbackDAO;
import projectDAO.feedback.model.Feedback;
import projectDAO.feedback.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FeedbackDAOImpl implements FeedbackDAO {

	Connection conn = DBUtil.getConnection();

	@Override
	public boolean addFeedback(Long user_id, String name, String email, String feedback) {
		String query = "insert into feedback(user_id, name, email, feedback) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, user_id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, feedback);
			int count = ps.executeUpdate();
			if (count>=1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Feedback> getFeedbackByUserId(Long id) {
		String query = "select * from feedback where user_id = ? order by f_id desc";
		List<Feedback> feedbackList = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Long f_id = rs.getLong("f_id");
				String feedback = rs.getString("feedback");
				Feedback ob = new Feedback(user_id, name, email, f_id, feedback);
				feedbackList.add(ob);
			}
			return feedbackList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		List<Feedback> feedbackList = new ArrayList<>();
		String sql = "select * from feedback";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long user_id = rs.getLong("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Long f_id = rs.getLong("f_id");
				String feedback = rs.getString("feedback");
				Feedback fb = new Feedback(user_id, name, email, f_id, feedback);
				feedbackList.add(fb);
			}
			return feedbackList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

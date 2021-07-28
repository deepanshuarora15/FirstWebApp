package projectDAO.feedback.dao;

import projectDAO.feedback.model.Feedback;

import java.util.List;

public interface FeedbackDAO {
	//boolean updateFeedback(Feedback feedback);
	boolean addFeedback(Long user_id, String name, String email, String feedback);
	List<Feedback> getFeedbackByUserId(Long id);
	List<Feedback> getAllFeedback();
}

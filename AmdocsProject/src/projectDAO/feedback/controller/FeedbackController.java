package projectDAO.feedback.controller;

import projectDAO.feedback.dao.FeedbackDAO;
import projectDAO.feedback.dao.impl.FeedbackDAOImpl;
import projectDAO.feedback.model.Feedback;

import java.util.List;

public class FeedbackController {

	public static void main(String[] args) {
		FeedbackDAO ob = new FeedbackDAOImpl();
		Feedback fb = new Feedback(103L, "Random", "random@gmail.com", 4L, "Good");
		//System.out.println("new feedback added " + ob.addFeedback(fb));
		//Feedback f = ob.getFeedbackByUserId(102L);
		//System.out.println("Feedback by user id 102L is " + f.toString());
		System.out.println("Now printing all feedbacks");
		List<Feedback> feedbackList = ob.getAllFeedback();
		for(Feedback ab : feedbackList){
			System.out.println(ab.toString());
		}
	}
}

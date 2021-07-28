

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectDAO.feedback.dao.FeedbackDAO;
import projectDAO.feedback.dao.impl.FeedbackDAOImpl;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/feed")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FeedbackDAO ob = new FeedbackDAOImpl();
		String name = request.getParameter("name");
		Long userid =  Long.parseLong(request.getParameter("userid"));
		String email =  request.getParameter("email");
		String feedback =  request.getParameter("feedback");
		if(ob.addFeedback(userid, name, email, feedback)) {
			response.sendRedirect("FeedbackForm.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

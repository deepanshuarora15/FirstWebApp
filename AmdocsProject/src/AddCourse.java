

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectDAO.course.dao.CourseDAO;
import projectDAO.course.dao.impl.CourseDAOImpl;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/addcourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course_name = request.getParameter("courseName");
		String course_resource = request.getParameter("courseResources");
		String course_description = request.getParameter("courseDescription");
		String coursefee = request.getParameter("courseFees");
		CourseDAO ob = new CourseDAOImpl();
		if(ob.addCourse(course_name, course_description, coursefee, course_resource)) {
			response.sendRedirect("CourseForm.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

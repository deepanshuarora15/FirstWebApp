

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectDAO.course.dao.CourseDAO;
import projectDAO.course.dao.impl.CourseDAOImpl;
import projectDAO.course.model.Course;
import projectDAO.enrollment.dao.EnrollmentDAO;
import projectDAO.enrollment.dao.impl.EnrollmentDAOImpl;
import projectDAO.user.model.User;


/**
 * Servlet implementation class EnrollUser
 */
@WebServlet("/enrolluser")
public class EnrollUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long courseid = Long.parseLong(request.getParameter("courseId"));
		CourseDAO ob = new CourseDAOImpl();
		Course obj = ob.getCourse(courseid);
		PrintWriter out = response.getWriter();
		if(obj==null) {
			out.println("No such course exists!");
			return;
		}
		HttpSession session = request.getSession();
		Long userId  = ((User)session.getAttribute("user")).getUser_id();
		String userName  = ((User)session.getAttribute("user")).getName();
		String c_name = obj.getC_name();
		String c_desp = obj.getC_desp();
		String c_fees = obj.getC_fees();
		String c_resource = obj.getC_resource();
		EnrollmentDAO endao = new EnrollmentDAOImpl();
		
		if(endao.getEnrollmentByUserandCourseID(userId,courseid)) {
			out.println("Already enrolled. Cannot enroll again");
		}
		else if(endao.addEnrollment(userId, userName, courseid, c_name, c_desp, c_fees, c_resource)) {
			response.sendRedirect("Enroll.jsp");
		}
		else {
			out.println("Oops! Something went wrong. Please try again");
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

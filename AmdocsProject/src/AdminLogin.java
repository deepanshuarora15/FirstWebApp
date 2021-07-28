

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projectDAO.admin.dao.AdminDAO;
import projectDAO.admin.dao.impl.AdminDAOImpl;
import projectDAO.admin.model.Admin;
import projectDAO.user.dao.UserDAO;
import projectDAO.user.dao.impl.UserDAOImpl;
import projectDAO.user.model.User;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminDAO ob = new AdminDAOImpl();
		String username = request.getParameter("admin");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Admin ad = ob.adminLogin(username , password);
		if(ad!=null) {
			session.setAttribute("admin", ad);
			response.sendRedirect("AdminHome.jsp");
		}
		else {
			response.sendRedirect("AdminLogin.jsp");
		}
	}
}



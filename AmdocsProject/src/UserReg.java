

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectDAO.user.model.User;

import projectDAO.user.dao.UserDAO;
import projectDAO.user.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class UserReg
 */
@WebServlet("/UserRegister")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReg() {
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Long phone = Long.parseLong(request.getParameter("phone"));
		String address = request.getParameter("address");
		String regdate = request.getParameter("regdate");
		String photoURL = request.getParameter("photoURL");
	
		UserDAO ob = new UserDAOImpl();
		User us = new User(1L, name, phone, email, address, regdate, password, photoURL);
		boolean i = ob.addUser(us);
		PrintWriter out = response.getWriter();
		if(i==true) {
			out.println("Registration Successful");
			out.println("<br/><a href=\"Login.jsp\">Login Page</a>");
		}
		else {
			out.println("Registration failed");
		}
	}

}

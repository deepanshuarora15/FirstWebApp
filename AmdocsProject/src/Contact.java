

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectDAO.contact.dao.ContactDAO;
import projectDAO.contact.dao.impl.ContactDAOImpl;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long userid = Long.parseLong(request.getParameter("userid"));
		//Long userid = 101L;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Long phone = Long.parseLong(request.getParameter("phone"));
		//Long phone = 1234L;
		String message = request.getParameter("message");
		ContactDAO ob = new ContactDAOImpl();
		PrintWriter out = response.getWriter();
		if(ob.connect(userid, name, email, phone, message)){
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('Contact form successfully submitted');");
//			out.println("</script>");
			response.sendRedirect("ContactForm.jsp");
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

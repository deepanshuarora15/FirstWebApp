package projectDAO.enrollment.controller;


import projectDAO.enrollment.dao.EnrollmentDAO;
import projectDAO.enrollment.dao.impl.EnrollmentDAOImpl;

public class EnrollmentController{

	public static void main(String[] args) {
		EnrollmentDAO ob = new EnrollmentDAOImpl();
		ob.addEnrollment(101L, "Deep", 111L, "ed3", "Sel", "ff", "ff");
		System.out.println(ob.getAllEnrollments().toString());
	}

}

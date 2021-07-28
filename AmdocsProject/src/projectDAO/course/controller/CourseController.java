package projectDAO.course.controller;

import projectDAO.course.dao.CourseDAO;
import projectDAO.course.dao.impl.CourseDAOImpl;
import projectDAO.course.model.Course;

public class CourseController {

	public static void main(String[] args) {
		CourseDAO ob = new CourseDAOImpl();
		Course obj = ob.getCourse(111L);
		System.out.println(obj.toString());
	}

}

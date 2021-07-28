package projectDAO.course.dao;

import projectDAO.course.model.Course;

import java.util.List;

public interface CourseDAO {

	boolean addCourse(String coursename, String coursedescription , String c_fees, String c_resource);
	Course getCourse(Long courseId);
	List<Course> getAllCourses();

}

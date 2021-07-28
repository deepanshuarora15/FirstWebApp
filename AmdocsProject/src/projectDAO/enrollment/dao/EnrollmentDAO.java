package projectDAO.enrollment.dao;

import projectDAO.enrollment.model.Enrollment;

import java.util.List;

public interface EnrollmentDAO {

	List<Enrollment> getAllEnrollments();
	boolean addEnrollment(Long user_id, String name, Long course_id, String c_name, String c_desp, String c_fees, String c_resource);
	List<Enrollment> getEnrollmentById(Long id);
	boolean getEnrollmentByUserandCourseID(Long userId, Long courseId);
}

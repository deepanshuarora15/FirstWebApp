package projectDAO.enrollment.model;

public class Enrollment {
	Long enroll_id;
	Long user_id;
	String name;
	Long course_id;
	String c_name;
	String c_desp;
	String c_fees;
	String c_resource;

	public Enrollment(Long enroll_id, Long user_id, String name, Long course_id, String c_name, String c_desp, String c_fees, String c_resource) {
		this.enroll_id = enroll_id;
		this.user_id = user_id;
		this.name = name;
		this.course_id = course_id;
		this.c_name = c_name;
		this.c_desp = c_desp;
		this.c_fees = c_fees;
		this.c_resource = c_resource;
	}
	
	public Long getEnroll_id() {
		return enroll_id;
	}

	public void setEnroll_id(Long enroll_id) {
		this.enroll_id = enroll_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_desp() {
		return c_desp;
	}

	public void setC_desp(String c_desp) {
		this.c_desp = c_desp;
	}

	public String getC_fees() {
		return c_fees;
	}

	public void setC_fees(String c_fees) {
		this.c_fees = c_fees;
	}

	public String getC_resource() {
		return c_resource;
	}

	public void setC_resource(String c_resource) {
		this.c_resource = c_resource;
	}

	@Override
	public String toString() {
		return "Enrollment{" +
				"user_id=" + user_id +
				", course_id=" + course_id +
				", c_name='" + c_name + '\'' +
				", c_desp='" + c_desp + '\'' +
				", c_fees='" + c_fees + '\'' +
				", c_resource='" + c_resource + '\'' +
				'}';
	}
}

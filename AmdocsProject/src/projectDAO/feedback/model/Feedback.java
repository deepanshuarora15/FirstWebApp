package projectDAO.feedback.model;

public class Feedback {

	private Long user_id;
	private String name;
	private String email;
	private Long f_id;
	private String feedback;

	public Feedback(Long user_id, String name, String email, Long f_id, String feedback){
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.f_id = f_id;
		this.feedback = feedback;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getF_id() {
		return f_id;
	}

	public void setF_id(Long f_id) {
		this.f_id = f_id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback{" +
				"user_id=" + user_id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", f_id=" + f_id +
				", feedback='" + feedback + '\'' +
				'}';
	}
}

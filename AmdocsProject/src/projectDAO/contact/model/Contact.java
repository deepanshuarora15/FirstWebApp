package projectDAO.contact.model;

public class Contact {
	private Long user_id;
	private String name;
	private String email;
	private Long phone_no;
	private String message;
	private Long contact_id;

	public Contact() {
		super();
	}

	public Contact(Long user_id, String name, String email, Long phone_no, String message, Long contact_id) {
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
		this.message = message;
		this.contact_id = contact_id;
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

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getContact_id() {
		return contact_id;
	}

	public void setContact_id(Long contact_id) {
		this.contact_id = contact_id;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"user_id=" + user_id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", phone_no=" + phone_no +
				", message='" + message + '\'' +
				", contact_id=" + contact_id +
				'}';
	}
}

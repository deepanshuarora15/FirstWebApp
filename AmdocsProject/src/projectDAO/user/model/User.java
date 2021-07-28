package projectDAO.user.model;

public class User {
	private Long user_id;
	private String name;
	private Long phone_no;
	private String email;
	private String address;
	private String reg_date;
	private String password;
	private String upload_photo;

	public User() {
		super();
	}

	public User(Long user_id, String name, Long phone_no, String email, String address, String reg_date, String password, String upload_photo) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.phone_no = phone_no;
		this.email = email;
		this.address = address;
		this.reg_date = reg_date;
		this.password = password;
		this.upload_photo = upload_photo;
	}

	public Long getUser_id() {
		return user_id;
	}

	public String getName() {
		return name;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getPassword() {
		return password;
	}

	public String getUpload_photo() {
		return upload_photo;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUpload_photo(String upload_photo) {
		this.upload_photo = upload_photo;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + user_id +
				", name='" + name + '\'' +
				", phone_no=" + phone_no +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", reg_date='" + reg_date + '\'' +
				", password='" + password + '\'' +
				", upload_photo='" + upload_photo + '\'' +
				'}';
	}
}

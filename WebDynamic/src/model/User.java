package model;

public class User {
	private int id;
	private String username;
	private boolean gender ;
	private String email;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(String username, boolean gender, String email, String password) {
		super();
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
	public User(int id, String username, boolean gender, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", gender=" + gender + ", email=" + email + ", password="
				+ password + "]";
	}

	
}
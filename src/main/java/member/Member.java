package member;

import java.util.Date;

public class Member {
	private String id;
	private String password;
	private String name;

	public Member() {

	}

	public Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean matchPassword(String password) {
		return this.password.equals(password);
	}
}

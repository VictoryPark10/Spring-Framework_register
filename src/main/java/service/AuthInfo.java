package service;

public class AuthInfo {
	private String id;
	private String name;

	public AuthInfo() {

	}

	public AuthInfo(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

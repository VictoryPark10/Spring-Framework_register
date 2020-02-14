package command;

public class LoginCommand {
	
	private String id;
	private String password;
	//private Boolean rememberId;
	
	public LoginCommand(){
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public Boolean isRememberId() {
		return rememberId;
	}
	public void setRememberId(Boolean rememberId) {
		this.rememberId = rememberId;
	}*/
}

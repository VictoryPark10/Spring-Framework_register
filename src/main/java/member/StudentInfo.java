package member;

public class StudentInfo {
	
	private String department;
	private int hak;
	private String ban;
	private String name;

	public StudentInfo(String department, int hak, String ban, String name) {
		this.department = department;
		this.hak = hak;
		this.ban = ban;
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}

	public int getHak() {
		return hak;
	}

	public String getBan() {
		return ban;
	}

	public String getName() {
		return name;
	}
}

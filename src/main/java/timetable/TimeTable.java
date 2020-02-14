package timetable;

public class TimeTable {
	private String day;
	private int startTime;
	private int endTime;
	private String kmName;
	private String profName;
	private String kmIsu;

	public TimeTable(String day, int startTime, int endTime, String kmName, String profName, String kmIsu) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.kmName = kmName;
		this.profName = profName;
		this.kmIsu = kmIsu;
	}

	public String getDay() {
		return day;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public String getKmName() {
		return kmName;
	}

	public String getProfName() {
		return profName;
	}

	public String getKmIsu() {
		return kmIsu;
	}
}

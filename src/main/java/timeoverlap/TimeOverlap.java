package timeoverlap;

public class TimeOverlap {
	private int startTime;
	private int endTime;

	public TimeOverlap(String starttime, String endtime) {
		this.startTime = Integer.parseInt(starttime);
		this.endTime = Integer.parseInt(endtime);
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}
}

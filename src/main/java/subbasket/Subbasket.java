package subbasket;

public class Subbasket {
	private String kmId;
	private String kmName;
	private int kmHak;
	private String kmBan;
	private String kmDay;
	private int kmTime;
	private String kmProf;
	private int kmCountBasket;
	private int kmLimit;
	private String kmIsu;
	private int kmGrade;

	public Subbasket(String kmId, String kmName, int kmHak, String kmBan, String kmDay, int kmTime, String kmProf,
			int kmCountBasket, int kmLimit, String kmIsu, int kmGrade) {
		this.kmId = kmId;
		this.kmName = kmName;
		this.kmHak = kmHak;
		this.kmBan = kmBan;
		this.kmDay = kmDay;
		this.kmTime = kmTime;
		this.kmProf = kmProf;
		this.kmCountBasket = kmCountBasket;
		this.kmLimit = kmLimit;
		this.kmIsu = kmIsu;
		this.kmGrade = kmGrade;
	}

	public String getKmId() {
		return kmId;
	}

	public String getKmName() {
		return kmName;
	}

	public int getKmHak() {
		return kmHak;
	}

	public String getKmBan() {
		return kmBan;
	}

	public String getKmProf() {
		return kmProf;
	}

	public int getKmTime() {
		return kmTime;
	}

	public int getKmCountBasket() {
		return kmCountBasket;
	}

	public int getKmLimit() {
		return kmLimit;
	}

	public String getKmIsu() {
		return kmIsu;
	}

	public int getKmGrade() {
		return kmGrade;
	}

	public String getKmDay() {
		return kmDay;
	}

}

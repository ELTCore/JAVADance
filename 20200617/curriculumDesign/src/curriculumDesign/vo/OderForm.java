package curriculumDesign.vo;

public class OderForm {
	private String time;
	private String randomNumber;

	public OderForm() {
		super();
	}

	public OderForm(String time, String randomNumber) {
		super();
		this.time = time;
		this.randomNumber = randomNumber;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public String toString() {
		return "OderForm [time=" + time + ", randomNumber=" + randomNumber + "]";
	}
	

}

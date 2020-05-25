package studentManage.vo;

//实体类，对应每一个学生的统计信息
public class Score {
	private String id;
	private String studentName;
	private String gender;
	private double totalScore;
	private double count;
	private double average;
	
	public Score() {
		super();
	}
	public Score(String id, String studentName, String gender, double totalScore, double count,double average) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.gender = gender;
		this.totalScore = totalScore;
		this.count = count;
		this.average = average;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	@Override
	public String toString() {
		return id + "\t" + studentName + "\t" + gender + "\t" + totalScore
				+ "\t" + average ;
	}
	
	

}

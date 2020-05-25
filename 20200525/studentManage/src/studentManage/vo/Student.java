package studentManage.vo;

public class Student {
	private String id;
	private String studentName;
	private String gender;
	private String courceName;
	private double score;
	
	public Student(String aLine) {
		String arr[]=aLine.split("\t");
		this.id = arr[0];
		this.studentName = arr[1];
		this.gender = arr[2];
		this.courceName = arr[3];
		this.score = Double.parseDouble(arr[4]);
		
	}
	public Student(String id, String studentName, String gender, String courceName, double score) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.gender = gender;
		this.courceName = courceName;
		this.score = score;
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
	public String getCourceName() {
		return courceName;
	}
	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return  id + "\t" + studentName + "\t" + gender + "\t"
				+ courceName + "\t" + score ;
	}
	
	

}

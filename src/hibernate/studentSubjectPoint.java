package hibernate;

public class studentSubjectPoint {
	private String idStudent;
	private String subjectCode;
	private String subjectName;
	private String classRoom;
	private float midPoint;
	private float endPoint;
	private float otherPoint;
	private float totalPoint;

	public studentSubjectPoint() {};
	
	public studentSubjectPoint(String idStudent, String subjectCode, String subjectName, String classRoom,
			float midPoint, float endPoint, float otherPoint, float totalPoint) {
		super();
		this.idStudent = idStudent;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.classRoom = classRoom;
		this.midPoint = midPoint;
		this.endPoint = endPoint;
		this.otherPoint = otherPoint;
		this.totalPoint = totalPoint;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public float getMidPoint() {
		return midPoint;
	}

	public void setMidPoint(float midPoint) {
		this.midPoint = midPoint;
	}

	public float getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(float endPoint) {
		this.endPoint = endPoint;
	}

	public float getOtherPoint() {
		return otherPoint;
	}

	public void setOtherPoint(float otherPoint) {
		this.otherPoint = otherPoint;
	}

	public float getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(float totalPoint) {
		this.totalPoint = totalPoint;
	}

}

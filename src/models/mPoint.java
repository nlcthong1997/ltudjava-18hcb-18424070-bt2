package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "points")
public class mPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "className")
	private String className;

	@Column(name = "subjectCode")
	private String subjectCode;

	@Column(name = "idStudent")
	private String idStudent;

	@Column(name = "midPoint")
	private float midPoint;

	@Column(name = "endPoint")
	private float endPoint;

	@Column(name = "otherPoint")
	private float otherPoint;

	@Column(name = "totalPoint")
	private float totalPoint;
	
	@Column(name = "nameStudent")
	private String nameStudent;

	public mPoint() {
	}

	public mPoint(int id, String className, String subjectCode, String idStudent, float midPoint, float endPoint,
			float otherPoint, float totalPoint, String nameStudent) {
		super();
		this.id = id;
		this.className = className;
		this.subjectCode = subjectCode;
		this.idStudent = idStudent;
		this.midPoint = midPoint;
		this.endPoint = endPoint;
		this.otherPoint = otherPoint;
		this.totalPoint = totalPoint;
		this.nameStudent = nameStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
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

package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentReference")
public class mStudent_reference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "idReference")
	private int idReference;

	@Column(name = "idStudent")
	private String idStudent;

	@Column(name = "nameStudent")
	private String nameStudent;

	@Column(name = "pointReference")
	private float pointReference;

	@Column(name = "pointHope")
	private float pointHope;

	@Column(name = "reason")
	private String reason;

	public mStudent_reference() {
	}

	public mStudent_reference(int id, int idReference, String idStudent, String nameStudent, float pointReference,
			float pointHope, String reason) {
		super();
		this.id = id;
		this.idReference = idReference;
		this.idStudent = idStudent;
		this.nameStudent = nameStudent;
		this.pointReference = pointReference;
		this.pointHope = pointHope;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdReference() {
		return idReference;
	}

	public void setIdReference(int idReference) {
		this.idReference = idReference;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public float getPointReference() {
		return pointReference;
	}

	public void setPointReference(float pointReference) {
		this.pointReference = pointReference;
	}

	public float getPointHope() {
		return pointHope;
	}

	public void setPointHope(float pointHope) {
		this.pointHope = pointHope;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}

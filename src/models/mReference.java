package models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "references")
public class mReference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Basic
	@Temporal(TemporalType.DATE)
	private java.util.Date fromDate;

	@Basic
	@Temporal(TemporalType.DATE)
	private java.util.Date toDate;

	@Column(name = "subjectCode")
	private String subjectCode;

	@Column(name = "subjectName")
	private String subjectName;

	public mReference() {
	}

	public mReference(int id, Date fromDate, Date toDate, String subjectCode, String subjectName) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	public java.util.Date getToDate() {
		return toDate;
	}

	public void setToDate(java.util.Date toDate) {
		this.toDate = toDate;
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

}

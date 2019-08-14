package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject_student")
public class mSubject_student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "idStudent")
	private String idStudent;

	@Column(name = "subjectCode")
	private String subjectCode;

	@Column(name = "nameSubject")
	private String nameSubject;

	@Column(name = "classroom")
	private String classroom;
	
	@Column(name = "className")
	private String className;

	public mSubject_student() {
	}

	public mSubject_student(int id, String idStudent, String subjectCode, String nameSubject, String classroom, String className) {
		super();
		this.id = id;
		this.idStudent = idStudent;
		this.subjectCode = subjectCode;
		this.nameSubject = nameSubject;
		this.classroom = classroom;
		this.className = className;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}

package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class mStudent {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="className")
	private String className;
	
	@Column(name="idStudent")
	private String idStudent;
	
	@Column(name="nameStudent")
	private String nameStudent;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="identityCard")
	private String identityCard;

	public mStudent() {}
	
	public mStudent(int id, String className, String idStudent, String nameStudent, String sex,
			String identityCard) {
		super();
		this.id = id;
		this.className = className;
		this.idStudent = idStudent;
		this.nameStudent = nameStudent;
		this.sex = sex;
		this.identityCard = identityCard;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

}

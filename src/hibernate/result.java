package hibernate;

public class result {
	private boolean status;
	private String message;
	private String typeUser;
	private String idUser;
	private String userName;

	public result(boolean status, String message, String typeUser, String idUser, String userName) {
		super();
		this.status = status;
		this.message = message;
		this.typeUser = typeUser;
		this.idUser = idUser;
		this.userName = userName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

package ar.edu.unlp.lifia.grupo8.domain.auth;

public abstract class AuthenticationType {

	private int id;
	
	public AuthenticationType() {}	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract boolean authenticateAgent();
}

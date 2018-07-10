package ar.edu.unlp.lifia.grupo8.domain.auth;

public class BasicAuthentication extends AuthenticationType {

	public BasicAuthentication() {}
	
	public boolean authenticateAgent(){		
		return true;
	}
}

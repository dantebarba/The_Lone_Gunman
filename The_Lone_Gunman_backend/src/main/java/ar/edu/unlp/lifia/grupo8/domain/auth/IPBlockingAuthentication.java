package ar.edu.unlp.lifia.grupo8.domain.auth;

public class IPBlockingAuthentication extends AuthenticationType {
	
	private int[] permittedIps;
	
	public IPBlockingAuthentication() {}
	
	public int[] getPermittedIps() {
		return permittedIps;
	}
	
	public void setPermittedIps(int[] permittedIps) {
		this.permittedIps = permittedIps;
	}
	
	public boolean authenticateAgent(){
		return true;
	}
}

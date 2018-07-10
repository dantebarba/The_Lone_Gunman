package ar.edu.unlp.lifia.grupo8.domain.accessrule;

public abstract class AccessRule {

	private int id;
	
	public AccessRule() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}

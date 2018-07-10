package ar.edu.unlp.lifia.grupo8.domain.accessrule;

import ar.edu.unlp.lifia.grupo8.domain.role.Role;


public class AccessByRole extends AccessRule {

	private Role role;
	
	public AccessByRole() {}
	
	public AccessByRole(Role role) {
		this.setRole(role);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}

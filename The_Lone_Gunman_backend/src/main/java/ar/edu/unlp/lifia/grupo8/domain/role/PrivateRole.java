package ar.edu.unlp.lifia.grupo8.domain.role;

import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;

public class PrivateRole extends Role {

	public PrivateRole() {}
	
	public PrivateRole(Agent agent){
		this.setAgent(agent);
	}
	
	@Override
	public String toString() {	
		return "Raso";
	}
}

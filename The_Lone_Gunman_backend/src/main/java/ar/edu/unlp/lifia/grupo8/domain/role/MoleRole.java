package ar.edu.unlp.lifia.grupo8.domain.role;

import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;

public class MoleRole extends Role {

	public MoleRole() {}
	
	public MoleRole(Agent agent){
		this.setAgent(agent);
	}
	
	@Override
	public String toString() {	
		return "Topo";
	}
}

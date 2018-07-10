package ar.edu.unlp.lifia.grupo8.domain.role;

import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;

public class LeaderRole extends Role{

	public LeaderRole() {}
	
	public LeaderRole(Agent agent){
		this.setAgent(agent);
	}
	
	@Override
	public String toString() {	
		return "Líder";
	}
	
	@Override
	public void deleteGroup(int idGroup) throws Exception {
		if(this.getGroup().getId() != idGroup) throw new Exception("El agente '"+this.getAgent().getName()+" "+this.getAgent().getSurname()+"' no tiene permitido eliminar al grupo '"+idGroup+"', ya que no pertenece al mismo.");
		this.getGroup().setMembers(null);
		this.getGroup().setLeader(null);
		this.setGroup(null);
	}
	
	@Override
	public void addAgentToGroup(int idGroup) throws Exception {
		if(this.getGroup().getId() != idGroup) throw new Exception("El agente '"+this.getAgent().getName()+" "+this.getAgent().getSurname()+"' no tiene permitido agregar un agente al grupo '"+idGroup+"', ya que no pertenece al mismo.");
		
	}
}

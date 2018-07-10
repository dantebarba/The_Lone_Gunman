package ar.edu.unlp.lifia.grupo8.domain.role;

import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessByRole;
import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRule;
import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRuleType;
import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.agent.Group;


public abstract class Role implements AccessRuleType{

	private int id;
	private Group group;
	private Agent agent;
	
	public Role() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Override
	public AccessRule accessRuleType() {
		AccessRule accessRule = new AccessByRole(this); 
		return accessRule;
	}
	
	/*
	 * El rol realiza el new del grupo, dejando lista la asociacion Agente->Rol->Grupo
	 * 
	 * @param name el nombre del grupo
	 * 
	 * @param description la descripcion del grupo
	 *  
	 */
	public void createGroup(String name, String description){
		this.setGroup(new Group(this, name, description));
	}
	
	public void deleteGroup(int idGroup) throws Exception{
		throw new Exception("El agente '"+this.getAgent().getName()+" "+this.getAgent().getSurname()+"' no tiene permitido eliminar al grupo '"+idGroup+"', ya que no es el jefe del mismo.");		
	}

	public void addAgentToGroup(int idGroup) throws Exception{
		throw new Exception("El agente '"+this.getAgent().getName()+" "+this.getAgent().getSurname()+"' no tiene permitido operar sobre el grupo '"+idGroup+"', ya que no es el jefe del mismo.");
	}
}

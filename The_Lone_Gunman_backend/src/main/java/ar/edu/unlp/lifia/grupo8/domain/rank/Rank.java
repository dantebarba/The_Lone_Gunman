package ar.edu.unlp.lifia.grupo8.domain.rank;

import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessByRank;
import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRule;
import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRuleType;
import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;

public abstract class Rank implements AccessRuleType{
	
	private int id;
	
	public Rank() {}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public AccessRule accessRuleType() {
		AccessRule accessRule = new AccessByRank(this);		
		return accessRule;
	}
	
	/*
	 * Aqui se delega la creacion de un grupo al rango del agente.	 *  
	 *
	 * @param agent el agente que crea el grupo
	 * 	 
	 * @throws exception
	 */
	public void createGroup(Agent agent) throws Exception{
		throw new Exception(agent.getName()+" "+agent.getSurname()+" no posee el rango suficiente para crear un grupo.");
	}
	
	/*
	 * Aqui se delega la eliminacion de un grupo al rango del agente.	 *  
	 *
	 * @param agent el agente que elimina el grupo
	 * 	 
	 * @throws exception
	 */
	public void deleteGroup(Agent agent) throws Exception{
		throw new Exception(agent.getName()+" "+agent.getSurname()+" no posee el rango suficiente para eliminar un grupo.");
	}
	
	/*
	 * Aqui se delega la insercion de un agente a un grupo al rango del agente.	 *  
	 *
	 * @param agent el agente que desea agregar al grupo
	 * 	 
	 * @throws exception
	 */
	public void addAgentToGroup(Agent agent) throws Exception{
		throw new Exception(agent.getName()+" "+agent.getSurname()+" no posee el rango suficiente para agregar un nuevo agente a un grupo.");
	}
	
	public abstract CodedMessage encodeMessage(CodedMessage message);
	
	public abstract CodedMessage decodeMessage(CodedMessage message);
	
	public abstract CryptedFile encryptFile(CryptedFile file);
	
	public abstract CryptedFile decryptFile(CryptedFile file);
}

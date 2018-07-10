package ar.edu.unlp.lifia.grupo8.dao;



import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;


public interface AgentDao extends GenericDao<Agent>{
	
	public Agent findByUsername(String username);

}

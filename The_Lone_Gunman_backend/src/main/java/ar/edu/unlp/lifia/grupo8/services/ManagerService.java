package ar.edu.unlp.lifia.grupo8.services;


import ar.edu.unlp.lifia.grupo8.dto.AgentDto;

public interface ManagerService {
		
	
	/* 
	 * Add a new Agent to the system
	 * 
	 * @param agent the agent you want to add
	 * 
	 * @return true if the agent was added successfully, false otherwise
	 */
	public boolean addNewAgent(AgentDto agentDto);

}

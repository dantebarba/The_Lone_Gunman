package ar.edu.unlp.lifia.grupo8.services.impl;

import ar.edu.unlp.lifia.grupo8.dto.AgentDto;
import ar.edu.unlp.lifia.grupo8.services.AgentService;
import ar.edu.unlp.lifia.grupo8.services.ManagerService;

public class ManagerServiceImpl implements ManagerService, java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7429849360894926608L;
	private AgentService agentService;
	
	
	public ManagerServiceImpl() {}
	
	
	/**
	 * @return the agentService
	 */
	public AgentService getAgentService() {
		return agentService;
	}


	/**
	 * @param agentService the agentService to set
	 */
	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}



	/* 
	 * Add a new Agent to the system with 
	 * 
	 * @param agent the agent you want to add
	 * 
	 * @return true if the agent was added successfully, false otherwise
	 */
	public boolean addNewAgent(AgentDto agentDto){
		int result = agentService.saveAgent(agentDto);
		return result != -1;
	}

}

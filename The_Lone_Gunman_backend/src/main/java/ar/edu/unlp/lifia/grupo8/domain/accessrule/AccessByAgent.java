package ar.edu.unlp.lifia.grupo8.domain.accessrule;

import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;

public class AccessByAgent extends AccessRule {

	private Agent agent;
	
	public AccessByAgent() {}
	
	public AccessByAgent(Agent agent) {
		this.setAgent(agent);
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}

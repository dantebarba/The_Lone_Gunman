package ar.edu.unlp.lifia.grupo8.domain.agent.state;

import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;

public abstract class AgentState {

	private int id;
	
	public AgentState() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * M�todo para solicitar un Cono de Silencio con otro agente.
	 * 
	 * @param agent el agente que solicita el Cono de Silencio; en este caso el Context
	 * del State.
	 * @param partner el agente con el que se establecer� el Cono de Silencio.	 * 
	 * 
	 * @return true si se establece el Cono de Silencio correctamente, false en caso contrario.
	 */
	public abstract boolean requestSilentPipe(Agent agent, Agent partner) throws Exception;
	
	/*
	 * M�todo a trav�s del cual un agente puede aceptar o rechazar la solicitud de Cono de Silencio
	 * que le env�a otro agente.
	 * 
	 * @param agent el agente que recibi� la solicitud.
	 * @param senderAgent el agente que envi� la solicitud.
	 * 
	 * @return ture si se acepta la solicitud, false en caso contrario 
	 */
	public abstract boolean acceptSilentPipe(Agent agent,Agent senderAgent) throws Exception;
	
	/*
	 * @return el agente con el cual se mantiene el Cono de Silencio. Si no se est� en Cono de Silencio
	 * se retorna null.
	 */
	public abstract Agent getSilentPipePartner();
	
	public abstract void receiveMessage(CodedMessage message, Conversation conversation);

	public abstract boolean disconectSilentPipe(Agent agent) throws Exception ;
}

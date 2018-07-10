package ar.edu.unlp.lifia.grupo8.domain.agent.state;

import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;


public class NormalState extends AgentState {

	public NormalState() {}
	
	@Override
	public String toString() {
		
		return "Normal...";
	}
	
	/*
	 * Método para solicitar un Cono de Silencio con otro agente.
	 * 
	 * @param agent el agente que solicita el Cono de Silencio; en este caso el Context
	 * del State.
	 * @param partner el agente con el que se establecerá el Cono de Silencio.	 * 
	 * 
	 * @return true si se establece el Cono de Silencio correctamente, false en caso contrario.
	 */
	public boolean requestSilentPipe(Agent agent,Agent partner) throws Exception{
		boolean result = false;
		result = partner.acceptSilentPipe(agent);			
		return result;
	}
	
	@Override
	public boolean disconectSilentPipe(Agent agent) throws Exception {
		throw new Exception("El agente '"+agent.getId()+"' no se encuentra en un cono de silencio");
	}
	
	/*
	 * Método a través del cual un agente puede aceptar o rechazar la solicitud de Cono de Silencio
	 * que le envía otro agente. Si el estado del agente es normal, se aceptara la solicitud y su
	 * estado cambiará a SilentPipeState.
	 * 
	 * @param agent el agente que recibió la solicitud.
	 * @param senderAgent el agente que envió la solicitud.
	 * 
	 * @return ture si se acepta la solicitud, false en caso contrario 
	 */
	public boolean acceptSilentPipe(Agent agent,Agent senderAgent){
		agent.establishSilentPipe(senderAgent);
		senderAgent.establishSilentPipe(agent);
		return true;
	}
	
	/*
	 * @return el agente con el cual se mantiene el Cono de Silencio. Si no se está en Cono de Silencio
	 * se retorna null.
	 */
	public Agent getSilentPipePartner(){
		return null;
	}
	
	@Override
	  public void receiveMessage(CodedMessage message, Conversation conversation) {
	      conversation.getMessages().add(message);
	    }
}

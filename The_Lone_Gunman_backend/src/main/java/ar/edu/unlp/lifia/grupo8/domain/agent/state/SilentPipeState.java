package ar.edu.unlp.lifia.grupo8.domain.agent.state;

import java.util.List;

import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;

public class SilentPipeState extends AgentState{

	private List<CodedMessage> pendingMessages;
	private Agent silentPipePartner;
	
	public SilentPipeState() {}
	
	public SilentPipeState(Agent partner){
		this.setSilentPipePartner(partner);
	}
	
	public List<CodedMessage> getPendingMessages() {
		return pendingMessages;
	}
	
	public void setPendingMessages(List<CodedMessage> pendingMessages) {
		this.pendingMessages = pendingMessages;
	}
	
	@Override
	public String toString() {
		
		return "En Cono de Silencio con "+this.getSilentPipePartner().getName()+" "+this.getSilentPipePartner().getSurname()+"...";
	}
	
	/*
	 * @return el agente con el cual se mantiene el Cono de Silencio. Si no se está en Cono de Silencio
	 * se retorna null.
	 */	
	public Agent getSilentPipePartner() {
		return silentPipePartner;
	}
	
	public void setSilentPipePartner(Agent silentPipePartner) {
		this.silentPipePartner = silentPipePartner;
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
		throw new Exception("el agente '"+agent.getId()+"' no puede solicitar un cono de silencio porque ya se encuentra en uno.");		
	}
	
	/*
	 * Método a través del cual un agente puede aceptar o rechazar la solicitud de Cono de Silencio
	 * que le envía otro agente.
	 * 
	 * @param agent el agente que recibió la solicitud.
	 * @param senderAgent el agente que envió la solicitud.
	 * 
	 * @return ture si se acepta la solicitud, false en caso contrario 
	 */
	public boolean acceptSilentPipe(Agent agent,Agent senderAgent) throws Exception{
		throw new Exception("Solicitud rechazada. El agente '"+agent.getId()+"' no puede aceptar un cono de silencio porque ya se encuentra en uno.");
	}
	
	@Override
	public boolean disconectSilentPipe(Agent agent) {
		this.getSilentPipePartner().establishNormalState();
		agent.establishNormalState();
		return true;
	}
	
	@Override
	  public void receiveMessage(CodedMessage message, Conversation conversation) {
	    this.getPendingMessages().add(message);
	  }

	
}

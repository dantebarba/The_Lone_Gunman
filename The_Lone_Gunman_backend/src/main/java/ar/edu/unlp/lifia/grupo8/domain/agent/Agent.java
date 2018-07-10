package ar.edu.unlp.lifia.grupo8.domain.agent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessByAgent;
import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRule;
import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRuleType;
import ar.edu.unlp.lifia.grupo8.domain.agent.state.AgentState;
import ar.edu.unlp.lifia.grupo8.domain.agent.state.NormalState;
import ar.edu.unlp.lifia.grupo8.domain.agent.state.SilentPipeState;
import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;
import ar.edu.unlp.lifia.grupo8.domain.rank.Rank;
import ar.edu.unlp.lifia.grupo8.domain.role.LeaderRole;
import ar.edu.unlp.lifia.grupo8.domain.role.Role;

public class Agent extends MessageReceptor implements AccessRuleType{
	
	
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
	private AgentState state;
	private Rank rank;
	private Role role;
	private Collection<Conversation> conversations;
	private Collection<CryptedFile> files;
	
	
	public Agent() {
		this.state = new NormalState();
//		this.receivedMessages = new HashSet<CodedMessage>();
//		this.sentMessages = new HashSet<CodedMessage>();
//		this.files = new HashSet<CryptedFile>();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String agentName) {
		this.name = agentName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public AgentState getState() {
		return state;
	}
	public void setState(AgentState state) {
		this.state = state;
	}

	/**
	 * @return the conversations
	 */
	public Collection<Conversation> getConversations() {
		return conversations;
	}


	/**
	 * @param conversations the conversations to set
	 */
	public void setConversations(Collection<Conversation> conversations) {
		this.conversations = conversations;
	}


	/**
	 * @return the files
	 */
	public Collection<CryptedFile> getFiles() {
		return files;
	}


	/**
	 * @param files the files to set
	 */
	public void setFiles(Collection<CryptedFile> files) {
		this.files = files;
	}


	@Override
	public AccessRule accessRuleType() {
		AccessRule accessRule = new AccessByAgent(this);
		return accessRule;
	}
	@Override
	public Rank encodingType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public boolean disconectSilentPipe() throws Exception{
		boolean result = false;
		result = this.getState().disconectSilentPipe(this);
		return result;
	}
	
	public void establishNormalState(){
		this.setState(new NormalState());
	}
	
	/*
	 * Método para solicitar un Cono de Silencio con otro agente.
	 * 
	 * @param partner el agente al que se le solicitará el Cono de Silencio.
	 * 
	 * @return true si se establece el Cono de Silencio correctamente, false en caso contrario.
	 */
	public boolean requestSilentPipe(Agent partner) throws Exception{
		boolean result = false;
		result = this.getState().requestSilentPipe(this,partner);
		return result;
	}
	
	/*
	 * Método a través del cual un agente puede aceptar o rechazar la solicitud de Cono de Silencio
	 * que le envía otro agente.
	 * 
	 * @param agent el agente que envió la solicitud.
	 * 
	 * @return ture si se acepta la solicitud, false en caso contrario 
	 */
	public boolean acceptSilentPipe(Agent agent) throws Exception{
		boolean result = false;
		result = this.getState().acceptSilentPipe(this,agent);
		return result;
	}
	
	/*
	 * Método para establecer un Cono de Silencio con otro agente.
	 * 
	 * @param partner el agente con el que se establecerá el Cono de Silencio.
	 * 
	 * @return true si se establece el Cono de Silencio correctamente, false en caso contrario.
	 */
	public void establishSilentPipe(Agent partner){
		this.setState(new SilentPipeState(partner));
		
	}

	/*
	 * @return el agente con el cual se mantiene el Cono de Silencio. Si no se está en Cono de Silencio
	 * se retorna null.
	 */
	public Agent getSilentPipePartner(){
		return this.getState().getSilentPipePartner();
	}
	
	/*
	 * Permite a un agente crear un nuevo grupo, delegando al rango esa responsabilidad,
	 * debido a que solo un agente con rango Veterano tiene permitido crear un grupo.De esta manera,
	 * todo rango inferior a Veterano lanzara un excepcion evitando que el codigo de creacion de grupo se
	 * ejecute.
	 * 
	 * @param name el nombre del grupo
	 * 
	 * @param description la descripcion del grupo
	 * 
	 */
	public void createGroup(String name, String description) throws Exception{
		if(this.getRole() != null ) throw new Exception("El agente '"+this.getName()+" "+this.getSurname()+"' no puede crear un grupo porque ya forma parte de uno.");		
		this.getRank().createGroup(this);//si no posee suficiente rango, se lanzara un excepcion
		this.setRole(new LeaderRole(this));
		this.getRole().createGroup(name, description);
	}	
	
	
	/*
	 * Permite a un agente eliminar un grupo, delegando al rango esa responsabilidad,
	 * debido a que solo un agente con rango Veterano tiene permitido eliminar un grupo. De esta manera,
	 * todo rango inferior a Veterano lanzara un excepcion evitando que el codigo de eliminacion del grupo se
	 * ejecute.
	 * 
	 * @param idGroup el id del grupo
	 * 
	 * @param description la descripcion del grupo
	 * 
	 * @return el id del rol del jefe del grupo
	 */
	public int deleteGroup(int idGroup) throws Exception{	
		if(this.getRole() == null ) throw new Exception("El agente '"+this.getName()+" "+this.getSurname()+"' no tiene permitido eliminar al grupo '"+idGroup+"'.");
		int idRol = this.getRole().getId();
		this.getRank().deleteGroup(this);//si no posee suficiente rango, se lanzara un excepcion
		this.getRole().deleteGroup(idGroup);
		this.setRole(null);
		return idRol;
	}
	
	
	/*
	 * Permite agregar un agente a un grupo, delegando al rango esa responsabilidad,
	 * debido a que solo un agente con rango Veterano tiene permitido eliminar un grupo. De esta manera,
	 * todo rango inferior a Veterano lanzara un excepcion evitando que se agregue el agente al grupo
	 * 
	 * @param group el grupo	  
	 * 
	 * @param agentToAdd el agente que se desea agregar	  
	 *
	 *@param role el nombre del rol que tendra el nuevo agente en el grupo
	 */
	public void addAgentToGroup(int idGroup, Agent agentToAdd, String role) throws Exception{
		if(this.getRole() == null ) throw new Exception("El agente '"+this.getName()+" "+this.getSurname()+"' no pertenece al grupo.");
		this.getRank().addAgentToGroup(this);//si no posee suficiente rango, se lanzara una excepcion
		this.getRole().addAgentToGroup(idGroup);//si no es jefe se lanzara una excepcion
		@SuppressWarnings("rawtypes")
		Class clase = Class.forName("ar.edu.unlp.lifia.grupo8.domain.role."+role);
		agentToAdd.setRole((Role) clase.newInstance());
		agentToAdd.getRole().setAgent(agentToAdd);
		agentToAdd.getRole().setGroup(this.getRole().getGroup());
	}
	
	public void removeAgentFromGroup(int idGroup, Agent agentToRemove) throws Exception{
		if(this.getRole() == null ) throw new Exception("El agente '"+this.getName()+" "+this.getSurname()+"' no pertenece al grupo.");
		this.getRank().addAgentToGroup(this);//si no posee suficiente rango, se lanzara una excepcion
		this.getRole().addAgentToGroup(idGroup);//si no es jefe se lanzara una excepcion		
		agentToRemove.setRole(null);
	}
	
	@Override
	  public boolean receiveMessage(CodedMessage message, Conversation conversation) {   
	    CodedMessage messageDecoded = this.getRank().decodeMessage(message);	    
	    if (conversation == null) {
	    Conversation conversationNew = new Conversation(this.getUsername(), message.getReceptor());
	    this.getState().receiveMessage(messageDecoded, conversationNew);
	    this.getConversations().add(conversationNew);
	  } else {
	    this.getState().receiveMessage(messageDecoded, conversation);
	  }
	    
	    return true;
	    
	  }
	  
	  public List<CodedMessage> sendMessage(CodedMessage message, List<CodedMessage> messages){
	    
		if (messages == null) {
			messages = new ArrayList<CodedMessage>();
			messages.add(message);
      } 
        messages.add(message);
      
      
      return messages;
      
	  }
	
}

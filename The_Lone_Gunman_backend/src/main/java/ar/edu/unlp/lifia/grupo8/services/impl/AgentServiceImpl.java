package ar.edu.unlp.lifia.grupo8.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;

import ar.edu.unlp.lifia.grupo8.converter.AgentConverterDto;
import ar.edu.unlp.lifia.grupo8.converter.CodedMessageConverterDto;
import ar.edu.unlp.lifia.grupo8.dao.AgentDao;
import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;
import ar.edu.unlp.lifia.grupo8.dto.AgentDto;
import ar.edu.unlp.lifia.grupo8.dto.CodedMessageDto;
import ar.edu.unlp.lifia.grupo8.dto.GroupDto;
import ar.edu.unlp.lifia.grupo8.dto.ResponseDto;
import ar.edu.unlp.lifia.grupo8.services.AgentService;
import ar.edu.unlp.lifia.grupo8.services.ConversationService;
import ar.edu.unlp.lifia.grupo8.services.RoleService;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class AgentServiceImpl implements AgentService, java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7429812430894926608L;
	private AgentDao agentDao;	
	private RoleService roleService;
	/**
	 * @return the conversationService
	 */
	public ConversationService getConversationService() {
		return conversationService;
	}

	/**
	 * @param conversationService the conversationService to set
	 */
	public void setConversationService(ConversationService conversationService) {
		this.conversationService = conversationService;
	}

	private ConversationService conversationService;
	
	
	public AgentServiceImpl() {}
	
	/**
	 * @return the agentDao
	 */
	public AgentDao getAgentDao() {
		return agentDao;
	}
	
	/**
	 * @param agentDao the agentDao to set
	 */
	public void setAgentDao(AgentDao agentDao) {
		this.agentDao = agentDao;
	}	


	/**
	 * @return the roleService
	 */
	public RoleService getRoleService() {
		return roleService;
	}

	/**
	 * @param roleService the roleService to set
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/*
	 * Método para guardar un agente en el Sistema
	 * 
	 * @param agent el agente que se desea guardar
	 * 
	 * @return el id del agente guardado o -1 en caso de falla
	 */
	public int saveAgent(AgentDto agentDto) throws HibernateException, NullPointerException{
		Agent agent = AgentConverterDto.convertToAgent(agentDto);
		int result = -1;
		try{
			agentDao.save(agent);
			result = agent.getId();
		}catch(ConstraintViolationException e){
			throw new HibernateException("No se pudo crear al agente '"+agent.getName()+" "+agent.getSurname()+"'."
    				+ "Causa raíz: "+e.getCause().getLocalizedMessage());
		}		
		return result;
	}
	
	
	/*
	 * Actualizar los datos de un agente determinado
	 * 
	 * @param agent el DTO de agente con los nuevos datos
	 * 
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean updateAgent(AgentDto agentDto) throws HibernateException, NullPointerException{
		boolean result = false;
		try{
			Agent agent = agentDao.findById(agentDto.getId());
			AgentConverterDto.convertToAgent(agentDto, agent);
			result = (agentDao.update(agent) != null);
		}catch (NullPointerException e){
			throw new NullPointerException("el agente con id '"+agentDto.getId()+"' no existe en el Sistema.");
		}catch (MySQLIntegrityConstraintViolationException e){
			throw new HibernateException(e.getCause().getLocalizedMessage());
		}		
		return result;
	}
	
	/*
	 * Método para borrar un agente buscandolo por su id.
	 * 
	 * @param id el id del agente que se desea eliminar
	 *  
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean deleteAgentById(int id) throws HibernateException, Exception{
		boolean result =  false;
		try {
			Agent agent = agentDao.findById(id);
			agentDao.delete(agent);
			result = true;
		} catch (NullPointerException e) {
			throw new Exception("el agente con id '"+id+"' no existe en el Sistema.");
		}catch (HibernateException e){
			throw new HibernateException(e.getCause().getLocalizedMessage());
		}
		
		return result;
	}
	
	/*
	 * Método para solicitar un Cono de Silencio con otro agente.
	 * 
	 * @param agent el agente emisor de la solicitud
	 * @param partner el agente al que se le solicitará el Cono de Silencio.
	 * 
	 * @return true si se establece el Cono de Silencio correctamente, false en caso contrario.
	 */
	public boolean requestSilentPipe(AgentDto agentDto, AgentDto partnerDto) throws NullPointerException,Exception{
		boolean result = false;
		Agent agent = agentDao.findById(agentDto.getId());
		Agent partner = agentDao.findById(partnerDto.getId());
		result = agent.requestSilentPipe(partner);		
		try {
			agentDao.update(agent);
		}catch (HibernateException e) {
			throw e;
		}catch (NullPointerException e) {
			throw e;
		}catch (Exception e) {
			throw e;
		}
		return result;
		
	}
	
	
	public boolean disconectSilentPipe(AgentDto agentDto) throws Exception{
		boolean result = false;
		Agent agent = agentDao.findById(agentDto.getId());
		Agent partner = agent.getSilentPipePartner();
		result = agent.disconectSilentPipe();		
		try {
			agentDao.update(partner);
			agentDao.update(agent);			
		}catch (HibernateException e) {
			throw e;
		}catch (NullPointerException e) {
			throw e;
		}catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	/*
	 * Método para recuperar todos los agentes del Sistema
	 * 
	 * @return una lista con todos los agentes del Sistema
	 */
	public List<ResponseDto> findAllAgents() throws Exception{
		List<ResponseDto> agents = new ArrayList<ResponseDto>();
		agents = AgentConverterDto.convertToDtoList(agentDao.list());
		if(agents.isEmpty()){
        	throw new Exception("No hay agentes cargados en el Sistema por el momento."); 
        }
		return agents;		
	}
	
	/*
	 * Método para recuperar un agente del Sistema, con determinado id
	 * 
	 * @param id el id del agente buscado
	 * 
	 * @return el DTO del agente encontrado o null en caso de falla
	 */
	public ResponseDto findById(int id) throws HibernateException, Exception{
		ResponseDto responseDto = null;
		try{			
			responseDto = AgentConverterDto.convertToDto(agentDao.findById(id));
		}catch (HibernateException e ) {			
			throw new HibernateException(e.getCause().getLocalizedMessage());
		}catch (NullPointerException e){				
			throw new Exception("el agente con id '"+id+"' no existe en el Sistema.");		
		}	
		return responseDto;
	}
	
	/*
	 * Permite a un agente crear un nuevo grupo
	 * 
	 * @param agentId el id del agente que desea crear el grupo
	 * 
	 * @param groupDto DTO con los datos del grupo
	 * 
	 * @return el id del nuevo grupo si fue creado correctamente, -1 si la operacion fallo
	 */
	public int newGroup(int agentId, GroupDto groupDto) throws HibernateException, Exception{
		Agent agent = null;
		int result = -1;
		try{			
			agent = agentDao.findById(agentId);
			agent.createGroup(groupDto.getName(), groupDto.getDescription());
			agentDao.update(agent);
			result = agent.getRole().getGroup().getId();			
		}catch (NullPointerException e){	
			throw new NullPointerException("el agente con id '"+agentId+"' no existe en el Sistema.");		
		}catch (Exception e){
			throw new Exception(e.getMessage());
		}
		return result;
	}
	
	/*
	 * Elimina el grupo con el id pasado como parametro, con las siguientes condiciones:
	 * - El agente pertenece al sistema
	 * - El agente posee el rango Veterano
	 * - El agente pertenece al grupo que se desea eliminar
	 * 
	 * @param idAgent el id del agente que desea borrar al grupo
	 * 
	 * @param idGroup el id del grupo que se desea borrar
	 * 
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean deleteGroupById(int idAgent, int idGroup)throws HibernateException, Exception{
		boolean result =  false;
		try {
			Agent agent = agentDao.findById(idAgent);
			int idRole = agent.deleteGroup(idGroup);
			agentDao.update(agent);
			roleService.deleteRoleById(idRole);
			result = true;			
		}catch (NullPointerException e){	
			throw new NullPointerException("el agente con id '"+idAgent+"' no existe en el Sistema.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}
		
		return result;
	}
	
	/*
	 * Agregar un nuevo agente al grupo
	 * 
	 * @param idAgent el id del agente que desea realizar la operacion
	 * 
	 * @param idGroup el id del grupo
	 * 
	 * @param idAgentToAdd el id del agente que se desea agregar
	 * 
	 * @param role el nombre del rol que tendra el nuevo agente en el grupo
	 * 
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean addAgentToGroup(int idAgent, int idGroup, int idAgentToAdd, String role)throws HibernateException, Exception{
		boolean result =  false;		
		try{
			Agent agentLeader = agentDao.findById(idAgent);
			Agent agentToAdd = agentDao.findById(idAgentToAdd);
			roleService.addAgentToGroup(agentLeader, idGroup, agentToAdd, role);;
			agentDao.update(agentToAdd);
			result = true;
		}catch (NullPointerException e){	
			throw new NullPointerException("el agente no existe en el Sistema.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}		
		return result;
	}
	
	/*
	 * Quitar un agente del grupo
	 * 
	 * @param idAgent el id del agente que desea realizar la operacion
	 * 
	 * @param idGroup el id del grupo
	 * 
	 * @param idAgentToRemove el id del agente que se desea quitar
	 * 
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean removeAgentFromGroup(int idAgent, int idGroup, int idAgentToRemove)throws HibernateException, Exception{
		boolean result =  false;		
		try{
			Agent agentLeader = agentDao.findById(idAgent);
			Agent agentToRemove = agentDao.findById(idAgentToRemove);
			roleService.removeAgentFromGroup(agentLeader, idGroup, agentToRemove);;
			agentDao.update(agentToRemove);
			result = true;
		}catch (NullPointerException e){	
			throw new NullPointerException("el agente no existe en el Sistema.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}		
		return result;
	}
	
	@Override
    public boolean receiveMessage(CodedMessageDto message, Conversation conversation) throws Exception, HibernateException {
      boolean result = false;
      Agent agentReceiver = agentDao.findByUsername(message.getReceptor());
      result = agentReceiver.receiveMessage(CodedMessageConverterDto.convertToCodedMessage(message), conversation);
      //Si la conversacion ya existe en el agentReceiver, solamente agrego el mensaje y updateo la conversacion
      conversationService.updateConversation(conversation);
      //Si la conversacion NO existe, entonces tengo que crearle la conversacion al agente, agregarle el mensaje, y updatear el agente que contiene esa conversacion.
      agentDao.update(agentReceiver);
      return result;
    }

    @Override
    public boolean sendMessage(CodedMessageDto message) throws MySQLIntegrityConstraintViolationException, HibernateException, Exception {
      boolean resultSend = false;
      boolean resultReceive = false;
      Agent agentReceiver = agentDao.findByUsername(message.getReceptor());
      Agent agentSender = agentDao.findByUsername(message.getSender());
      
      //Busco la conversacion del que envia el mensaje, y envio el mensaje agregando el mensaje enviado a dicha conversacion.
      Conversation conversation = conversationService.findConversationBySecretNameSenderAndReceiver(agentSender.getUsername(), agentReceiver.getUsername());
      List<CodedMessage> messages = conversationService.getCodedMessagesByUserNameSenderAndReceiver(agentSender.getUsername(), agentReceiver.getUsername());
      messages = agentSender.sendMessage(CodedMessageConverterDto.convertToCodedMessage(message), messages);
      
      if (conversation == null) {
		conversation = new Conversation();
	}
      conversation.setMessages(messages);
      
      //Si la conversacion ya existe en el agentReceiver, solamente agrego el mensaje y updateo la conversacion (esto se hace en el sendMessage de agente).
      //Hago que se reciba el mensaje correspondientemente, agregando en el receptor el mensaje.
      resultReceive = this.receiveMessage(message);
      
      conversationService.saveOrUpdate(conversation);
     
      return resultSend && resultReceive;
      
    }

	@Override
	public boolean receiveMessage(CodedMessageDto message) throws Exception,
			HibernateException {
		// TODO Auto-generated method stub
		return false;
	}
}

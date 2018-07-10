package ar.edu.unlp.lifia.grupo8.services;

import java.util.List;

import org.hibernate.HibernateException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.dto.AgentDto;
import ar.edu.unlp.lifia.grupo8.dto.CodedMessageDto;
import ar.edu.unlp.lifia.grupo8.dto.GroupDto;
import ar.edu.unlp.lifia.grupo8.dto.ResponseDto;

public interface AgentService {
		
	
	/*
	 * Método para guardar un agente en el Sistema
	 * 
	 * @param agent el agente que se desea guardar
	 * 
	 * @return el id del agente guardado o -1 en caso de falla
	 */
	public int saveAgent(AgentDto agentDto) throws HibernateException, NullPointerException;
	
	
	/*
	 * Actualizar los datos de un agente determinado
	 * 
	 * @param agent el DTO de agente con los nuevos datos
	 * 
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean updateAgent(AgentDto agent) throws HibernateException, NullPointerException;
	
	/*
	 * Método para borrar un agente buscandolo por su id.
	 * 
	 * @param id el id del agente que se desea eliminar
	 *  
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean deleteAgentById(int id) throws HibernateException, Exception;

	/*
	 * Método para solicitar un Cono de Silencio con otro agente.
	 * 
	 * @param agent el agente emisor de la solicitud
	 * @param partner el agente al que se le solicitará el Cono de Silencio.
	 * 
	 * @return true si se establece el Cono de Silencio correctamente, false en caso contrario.
	 */	
	public boolean requestSilentPipe(AgentDto agentDto, AgentDto partnerDto) throws Exception;
	
	public boolean disconectSilentPipe(AgentDto agentDto)throws Exception;
	
	/*
	 * Método para recuperar todos los agentes del Sistema
	 * 
	 * @return una lista con todos los agentes del Sistema
	 */
	public List<ResponseDto> findAllAgents() throws Exception;
	
	/*
	 * Método para recuperar un agente del Sistema, con determinado id
	 * 
	 * @param id el id del agente buscado
	 * 
	 * @return el DTO del agente encontrado o null en caso de falla
	 */
	public ResponseDto findById(int id) throws HibernateException, Exception;

	/*
	 * Permite a un agente crear un nuevo grupo
	 * 
	 * @param agentId el id del agente que desea crear el grupo
	 * 
	 * @param groupDto DTO con los datos del grupo
	 * 
	 * @return el id del nuevo grupo si fue creado correctamente, -1 si la operacion fallo
	 */
	public int newGroup(int agentId, GroupDto groupDto)throws HibernateException, Exception;
	
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
	public boolean deleteGroupById(int idAgent, int idGroup)throws HibernateException, Exception;
	
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
	public boolean addAgentToGroup(int idAgent, int idGroup, int idAgentToAdd, String role)throws HibernateException, Exception;
	
	
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
	public boolean removeAgentFromGroup(int idAgent, int idGroup, int idAgentToRemove)throws HibernateException, Exception;
	
	public boolean receiveMessage(CodedMessageDto message) throws Exception, HibernateException;
	
	public boolean sendMessage(CodedMessageDto message) throws MySQLIntegrityConstraintViolationException, HibernateException, Exception;


	boolean receiveMessage(CodedMessageDto message, Conversation conversation)
			throws Exception, HibernateException;
}

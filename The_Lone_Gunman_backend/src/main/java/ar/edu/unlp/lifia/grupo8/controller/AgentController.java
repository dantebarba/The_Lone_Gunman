/**
 * 
 */
package ar.edu.unlp.lifia.grupo8.controller;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ar.edu.unlp.lifia.grupo8.converter.RankConverterDto;
import ar.edu.unlp.lifia.grupo8.domain.rank.Counterintelligent;
import ar.edu.unlp.lifia.grupo8.domain.rank.Rank;
import ar.edu.unlp.lifia.grupo8.domain.rank.Rookie;
import ar.edu.unlp.lifia.grupo8.domain.rank.Veteran;
import ar.edu.unlp.lifia.grupo8.dto.AgentDto;
import ar.edu.unlp.lifia.grupo8.dto.CodedMessageDto;
import ar.edu.unlp.lifia.grupo8.dto.GroupDto;
import ar.edu.unlp.lifia.grupo8.dto.RankDto;
import ar.edu.unlp.lifia.grupo8.dto.ResponseDto;
import ar.edu.unlp.lifia.grupo8.dto.generic.GenericDto;
import ar.edu.unlp.lifia.grupo8.services.AgentService;

/**
 * @author Agustin
 *
 */
@RestController
public class AgentController {

	private AgentService agentService;
	
	
	public AgentService getAgentService() {
		return agentService;
	}
	
	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}
	
	
	/*
	 * Obtener todos los agentes del Sistema	 * 
	 * 
	 */
	@RequestMapping(value = "/agent", method = RequestMethod.GET)
    public ResponseEntity<List<ResponseDto>> listAllAgents() {
		List<ResponseDto> agents;
		try{
			agents = this.getAgentService().findAllAgents();
		}catch (HibernateException e ) {
			agents = new ArrayList<ResponseDto>();
			agents.add(new GenericDto("La solicitud no pudo ser procesada. Causa: "+e.getMessage()));
			return new ResponseEntity<List<ResponseDto>>(agents, HttpStatus.CONFLICT);
		}catch(Exception e){
			agents = new ArrayList<ResponseDto>();
			agents.add(new GenericDto("Sin contenido."+e.getMessage()));
			return new ResponseEntity<List<ResponseDto>>(agents, HttpStatus.NO_CONTENT);
		}
                
        return new ResponseEntity<List<ResponseDto>>(agents, HttpStatus.OK);
    }
	
	
    /*
     * Obtener el agente con un determinado id
     * 
     * @param id el id del agente
     */
    @RequestMapping(value = "/agent/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto> getAgent(@PathVariable("id") int id) {
    	ResponseDto responseDto = null;
    	
    	try{			
			responseDto = this.getAgentService().findById(id);
		}catch (HibernateException e ) {			
			return new ResponseEntity<ResponseDto>(new GenericDto("La solicitud no pudo ser procesada. Causa: "+e.getMessage()), HttpStatus.CONFLICT);
		}catch (Exception e){				
			return new ResponseEntity<ResponseDto>(new GenericDto("Recurso no encontrado. Causa: "+e.getMessage()), HttpStatus.NOT_FOUND);	
		}    	
    	
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
 
     
     
         
    @RequestMapping(value = "/agent/", method = RequestMethod.POST)
    public ResponseEntity<String> createAgent(@RequestBody AgentDto agent,    UriComponentsBuilder ucBuilder) {
    	
    	int idAgent = -1;
    	try{
    		idAgent = agentService.saveAgent(agent);   			
		}catch(HibernateException e){		
			return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa: "+e.getMessage(), HttpStatus.CONFLICT);
		}      
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/agent/{id}").buildAndExpand(idAgent).toUri());
        return new ResponseEntity<String>("Agente '"+agent.getName()+" "+agent.getSurname()+"' creado correctamente.",headers, HttpStatus.CREATED);
    }
 
             
    @RequestMapping(value = "/agent/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAgent(@PathVariable("id") int id, @RequestBody AgentDto agent, UriComponentsBuilder ucBuilder) {         
        
    	agent.setId(id);        
        try{
    		agentService.updateAgent(agent);   			
		}catch(NullPointerException e){
        	return new ResponseEntity<String>("Recurso no encontrado. No se pudo modificar al agente con id '"+id+"'. Causa: "+e.getMessage(),HttpStatus.NOT_FOUND);
        }catch(Exception e){		
			return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa: "+e.getMessage(), HttpStatus.CONFLICT);
        }
         
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/agent/{id}").buildAndExpand(id).toUri());
        return new ResponseEntity<String>("Agente '"+agent.getName()+" "+agent.getSurname()+"' modificado correctamente.",headers, HttpStatus.OK);
    }
 
         
    @RequestMapping(value = "/agent/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAgent(@PathVariable("id") int id) {        
 
        try{
        	agentService.deleteAgentById(id);
        }catch (HibernateException e){
        	return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa:  "+e.getMessage(),HttpStatus.CONFLICT);
        }catch(Exception e){
        	return new ResponseEntity<String>("Recurso no encontrado. No se pudo eliminar al agente con id '"+id+"'. Causa: "+e.getMessage(),HttpStatus.NOT_FOUND);
        }        
        return new ResponseEntity<String>("Agente eliminado correctamente.",HttpStatus.NO_CONTENT);
    } 
    
    @RequestMapping(value = "/agent/{id}/group/", method = RequestMethod.POST)
    public ResponseEntity<String> createGroup(@PathVariable("id") int id, @RequestBody GroupDto group,    UriComponentsBuilder ucBuilder) {

    	int idGroup = -1;  
    	try{
    		idGroup = agentService.newGroup(id, group);   			
		}catch(NullPointerException e){		
			return new ResponseEntity<String>("Recurso no encontrado. No se pudo crear al grupo. Causa: "+e.getMessage(),HttpStatus.NOT_FOUND);
		}catch(Exception e){
			return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa: "+e.getMessage(), HttpStatus.CONFLICT);        	
        }  
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/group/{id}").buildAndExpand(idGroup).toUri());
        return new ResponseEntity<String>("Grupo creado correctamente.",headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/agent/{idAgent}/group/{idGroup}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteGroup(@PathVariable("idAgent") int idAgent, @PathVariable("idGroup") int idGroup) {
 
		try{
			agentService.deleteGroupById(idAgent,idGroup);
		}catch (HibernateException e){
			return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa:  "+e.getMessage(),HttpStatus.CONFLICT);
		}catch(Exception e){
			return new ResponseEntity<String>("Recurso no encontrado. No se pudo eliminar al grupo con id '"+idGroup+"'. Causa: "+e.getMessage(),HttpStatus.NOT_FOUND);
		} 
		 
 		return new ResponseEntity<String>("Grupo eliminado correctamente.",HttpStatus.NO_CONTENT);
    } 
    
    @RequestMapping(value = "/agent/{idAgent}/group/{idGroup}/{idAgentToAdd}/{role}", method = RequestMethod.GET)
    public ResponseEntity<String> addAgentToGroup(@PathVariable("idAgent") int idAgent, @PathVariable("idGroup") int idGroup, @PathVariable("idAgentToAdd") int idAgentToAdd, @PathVariable("role") String role) {        
 
    	try{
    		agentService.addAgentToGroup(idAgent,idGroup,idAgentToAdd,role); 
		}catch (HibernateException e){
			return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa:  "+e.getMessage(),HttpStatus.CONFLICT);
		}catch(Exception e){
			return new ResponseEntity<String>("Recurso no encontrado. No se pudo agregar un agente al grupo '"+idGroup+"'. Causa: "+e.getMessage(),HttpStatus.NOT_FOUND);
		}
    	
        return new ResponseEntity<String>("Agente '"+idAgentToAdd+"' agregado correctamente al grupo '"+idGroup+"'.",HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/agent/{idAgent}/group/{idGroup}/{idAgentToRemove}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeAgentFromGroup(@PathVariable("idAgent") int idAgent, @PathVariable("idGroup") int idGroup, @PathVariable("idAgentToRemove") int idAgentToRemove) {        
 
    	try{
    		agentService.removeAgentFromGroup(idAgent,idGroup,idAgentToRemove); 
		}catch (HibernateException e){
			return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa:  "+e.getMessage(),HttpStatus.CONFLICT);
		}catch(Exception e){
			return new ResponseEntity<String>("Recurso no encontrado. No se pudo quitar al agente del grupo '"+idGroup+"'. Causa: "+e.getMessage(),HttpStatus.NOT_FOUND);
		}
    	
        return new ResponseEntity<String>("Agente '"+idAgentToRemove+"' quitado correctamente del grupo '"+idGroup+"'.",HttpStatus.OK);
    }
    
    @RequestMapping(value = "/agent/message/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> sendMessage(@RequestBody CodedMessageDto codedMessageDto) {        
 
    	try{
    		agentService.sendMessage(codedMessageDto);
		}catch (HibernateException e){
			return new ResponseEntity<String>("No se pudo enviar el mensaje. Causa:  "+e.getMessage(),HttpStatus.CONFLICT);
		}catch(Exception e){
			return new ResponseEntity<String>("No se pudo enviar el mensaje",HttpStatus.NOT_FOUND);
		}
    	
        return new ResponseEntity<String>("El mensaje fue enviado exitosamente",HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/agent/{idAgent}/request_silent/{idPartner}", method = RequestMethod.GET)
    public ResponseEntity<String> requestSilentPipe(@PathVariable("idAgent") int idAgent, @PathVariable("idPartner") int idPartner) {        
 
    	AgentDto agentDto = new AgentDto();
    	agentDto.setId(idAgent);
    	AgentDto partnerDto = new AgentDto();
    	partnerDto.setId(idPartner);
    	try{
    		agentService.requestSilentPipe(agentDto, partnerDto); 
		}catch (HibernateException e){
			return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa:  "+e.getMessage(),HttpStatus.CONFLICT);
		}catch(NullPointerException e){
			return new ResponseEntity<String>("Recurso no encontrado. No se pudo establecer un cono de silencio entre los agentes. Causa: "+e.getMessage(),HttpStatus.NOT_FOUND);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
    	
        return new ResponseEntity<String>("Cono de silencio establecido correctamente entre los agentes '"+idAgent+"' y '"+idPartner+"'.",HttpStatus.OK);
    } 
    
    @RequestMapping(value = "/agent/{idAgent}/request_silent/", method = RequestMethod.DELETE)
    public ResponseEntity<String> disconectSilentPipe(@PathVariable("idAgent") int idAgent) {        
 
    	AgentDto agentDto = new AgentDto();
    	agentDto.setId(idAgent);
    	try{
    		agentService.disconectSilentPipe(agentDto); 
		}catch (HibernateException e){
			return new ResponseEntity<String>("La solicitud no pudo ser procesada. Causa:  "+e.getMessage(),HttpStatus.CONFLICT);
		}catch(NullPointerException e){
			return new ResponseEntity<String>("Recurso no encontrado. No se pudo desconectar el cono de silencio. Causa: "+e.getMessage(),HttpStatus.NOT_FOUND);
		}catch(Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
    	
        return new ResponseEntity<String>("Cono de silencio desconectado correctamente entre los agentes.",HttpStatus.OK);
    }
    
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public ResponseEntity<List<RankDto>> getRanks() {
    	List<RankDto> listaDto = new ArrayList<RankDto>();
    	listaDto.add(RankConverterDto.convertToDto(new Rookie()));
    	listaDto.add(RankConverterDto.convertToDto(new Veteran()));
    	listaDto.add(RankConverterDto.convertToDto(new Counterintelligent()));
    	ResponseEntity<List<RankDto>> respuesta = new ResponseEntity<List<RankDto>>(listaDto, HttpStatus.OK);
    	return respuesta;
    }

}

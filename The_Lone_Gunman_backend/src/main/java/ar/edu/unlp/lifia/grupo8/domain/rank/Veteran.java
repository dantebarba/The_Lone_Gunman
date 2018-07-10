package ar.edu.unlp.lifia.grupo8.domain.rank;

import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;

/**
 * @author Agustin
 *
 */
public class Veteran extends Rank {

	public Veteran() {}
	
		
	@Override
	public String toString() {	
		return "Veterano";
	}
	
	/*
	 * Aqui se delega la creacion de un grupo al rango del agente, que en este caso al ser Veterano, 
	 * esta en condiciones de hacerlo.  
	 *
	 * @param agent el agente que crea el grupo
	 *	
	 * @throws exception
	 */
	@Override
	public void createGroup(Agent agent) throws Exception{
		// Este rango es suficiente para crear un grupo, por lo que no se dispara excepcion alguna
	}
	
	@Override
	public void deleteGroup(Agent agent) throws Exception{
		// Este rango es suficiente para eliminar un grupo, por lo que no se dispara excepcion alguna
	}
	
	@Override
	public void addAgentToGroup(Agent agent) throws Exception {
		// Este rango es suficiente para añadir agentes a un grupo, por lo que no se dispara excepcion alguna		
	}
	
	public CodedMessage encodeMessage(CodedMessage message){
		return message;
	}
	public CodedMessage decodeMessage(CodedMessage message){
		return message;
	}
	public CryptedFile encryptFile(CryptedFile file){
		return file;
	}
	public CryptedFile decryptFile(CryptedFile file){
		return file;
	}
}

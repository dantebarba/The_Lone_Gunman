package ar.edu.unlp.lifia.grupo8.services;


import java.util.List;

import org.hibernate.HibernateException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import ar.edu.unlp.lifia.grupo8.domain.agent.Group;
import ar.edu.unlp.lifia.grupo8.dto.ResponseDto;

public interface GroupService {

	/*
	 * Método para recuperar todos los grupos del Sistema
	 * 
	 * @return una lista con todos los grupos del Sistema
	 */
	public List<ResponseDto> findAllGroups();
	
	/*
	 * Método para recuperar un grupo del Sistema, con determinado id
	 * 
	 * @param id el id del grupo buscado
	 * 
	 * @return el grupo buscado o null si no se encontro
	 */
	public ResponseDto findById(int id);
	
	/*
	 * Método para borrar un grupo buscandolo por su id.
	 * 
	 * @param id el id del grupo que se desea eliminar
	 *  
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean deleteGroupById(int id) throws Exception;
	
	public boolean deleteGroup(Group group) throws Exception;
	
	public void updateGroup(Group group) throws MySQLIntegrityConstraintViolationException, HibernateException;
	
	
}

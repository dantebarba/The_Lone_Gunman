/**
 * 
 */
package ar.edu.unlp.lifia.grupo8.services.impl;

import java.util.Collection;

import ar.edu.unlp.lifia.grupo8.dao.RoleDao;
import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.role.Role;
import ar.edu.unlp.lifia.grupo8.services.GroupService;
import ar.edu.unlp.lifia.grupo8.services.RoleService;

/**
 * @author Agustin
 *
 */
public class RoleServiceImpl implements RoleService, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RoleDao roleDao;
	private GroupService groupService;
	
	public RoleServiceImpl() {}



	/**
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}



	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}



	/**
	 * @return the groupService
	 */
	public GroupService getGroupService() {
		return groupService;
	}



	/**
	 * @param groupService the groupService to set
	 */
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}



	/*
	 * Método para borrar un rol buscandolo por su id.
	 * 
	 * @param id el id del rol que se desea eliminar
	 *  
	 * @return true en caso de exito, false en caso de fracaso
	 */
	public boolean deleteRoleById(int id) throws Exception{
		boolean result =  false;
		try {
			Role role = roleDao.findById(id);
			Collection<Role> members = roleDao.getGroupMembers(role.getGroup().getId());
			members.clear();
			role.getGroup().setMembers(members);
			roleDao.delete(role);
			groupService.deleteGroup(role.getGroup());
//			roleDao.delete(role);			
			result = true;			
		} catch (Exception e) {
			result = false;
			throw new Exception(e.getLocalizedMessage());
		}		
		return result;
	}
	
	public void addAgentToGroup(Agent agentLeader, int idGroup, Agent agentToAdd, String role) throws Exception{
		try{			
			Collection<Role> members = roleDao.getGroupMembers(agentLeader.getRole().getId());
			agentLeader.addAgentToGroup(idGroup, agentToAdd, role);		
			members.add(agentToAdd.getRole());
			agentLeader.getRole().getGroup().setMembers(members);
		} catch (NullPointerException e) {
			throw new Exception("el grupo '"+idGroup+"' no existe en el Sistema.");
		}
	}
	
	public void removeAgentFromGroup(Agent agentLeader, int idGroup, Agent agentToRemove) throws Exception{
		try{			
			Collection<Role> members = roleDao.getGroupMembers(agentLeader.getRole().getId());
			//Role agentToRemoveRole = agentToRemove.getRole();
			agentLeader.removeAgentFromGroup(idGroup, agentToRemove);		
			members.remove(agentToRemove.getRole());
			agentLeader.getRole().getGroup().setMembers(members);
		} catch (NullPointerException e) {
			throw new Exception("el grupo '"+idGroup+"' no existe en el Sistema.");
		}
	}
}

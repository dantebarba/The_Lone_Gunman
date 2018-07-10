/**
 * 
 */
package ar.edu.unlp.lifia.grupo8.dao;

import java.util.Collection;

import ar.edu.unlp.lifia.grupo8.domain.role.Role;


/**
 * @author Agustin
 *
 */
public interface RoleDao extends GenericDao<Role> {


	public Collection<Role> getGroupMembers(int idRole);
}

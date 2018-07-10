/**
 * 
 */
package ar.edu.unlp.lifia.grupo8.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.lifia.grupo8.dao.RoleDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.role.Role;

/**
 * @author Agustin
 *
 */
@Transactional
public class RoleDaoHibJpa extends GenericDaoHibernateImpl<Role> implements
	RoleDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5757893946758327575L;

	@SuppressWarnings("unchecked")
	public Collection<Role> getGroupMembers(int idRole){
		Collection<Role> resultList =  null;
		
		Query query;
		query = this.getCurrentSession().createQuery("SELECT g.members FROM Role r JOIN r.group g WHERE r.id = :idRole");
		
		query.setParameter("idRole", idRole);
		
		resultList = query.list();
		
		return new HashSet<Role>(resultList);
	}
}

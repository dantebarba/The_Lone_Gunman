/**
 * 
 */
package ar.edu.unlp.lifia.grupo8.dao.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.lifia.grupo8.dao.GroupDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.agent.Group;

/**
 * @author Agustin
 *
 */
@Transactional
public class GroupDaoHibJpa extends GenericDaoHibernateImpl<Group> implements
		GroupDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5757893946758327575L;

	
	
}

package ar.edu.unlp.lifia.grupo8.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.lifia.grupo8.dao.AuthenticationTypeDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.auth.AuthenticationType;


@Transactional
public class AuthenticationTypeDaoHibJpa extends GenericDaoHibernateImpl<AuthenticationType> implements
AuthenticationTypeDao, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1823229741206420834L;
	
		
	
}

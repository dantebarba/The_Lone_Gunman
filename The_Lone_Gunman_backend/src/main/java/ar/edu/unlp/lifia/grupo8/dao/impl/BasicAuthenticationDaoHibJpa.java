package ar.edu.unlp.lifia.grupo8.dao.impl;

import ar.edu.unlp.lifia.grupo8.dao.BasicAuthenticationDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.auth.AuthenticationType;

public class BasicAuthenticationDaoHibJpa extends GenericDaoHibernateImpl<AuthenticationType> implements
BasicAuthenticationDao, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 877350310423819255L;
	
	
}

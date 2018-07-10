package ar.edu.unlp.lifia.grupo8.dao.impl;

import ar.edu.unlp.lifia.grupo8.dao.IPBlockingAuthenticationDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.auth.AuthenticationType;

public class IPBlockingAuthenticationDaoHibJpa extends GenericDaoHibernateImpl<AuthenticationType> implements
IPBlockingAuthenticationDao, java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6102976754221486100L;
	/*
	public boolean validate (String ipPath){
		
		Query q = (Query) this.getCurrentSession().createQuery("from IP where ipPath=: ipPath" );
		q.setParameter("ipPath", ipPath);
		
		
		boolean resultado;
		if(q.getResultList().size() == 1){
			resultado = (Agent) q.getSingleResult();
		}else{
			resultado = null;
		}
	
		
		return resultado;


}*/

	
	

}
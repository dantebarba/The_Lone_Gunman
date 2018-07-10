package ar.edu.unlp.lifia.grupo8.dao.impl;

import ar.edu.unlp.lifia.grupo8.dao.AgentDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;

import org.hibernate.Query;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AgentDaoHibJpa extends GenericDaoHibernateImpl<Agent> implements
		AgentDao, java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1000221668167430730L;

	public Agent findByUsername(String username){
		
		Query query = this.getCurrentSession().createQuery("SELECT a FROM Agent a WHERE a.username = :username");
		query.setParameter("username", username);
		try{
			return (Agent) query.uniqueResult();	
		}catch(NoResultException nre ) {  
	        return null;  
	    }		
		
	}

}

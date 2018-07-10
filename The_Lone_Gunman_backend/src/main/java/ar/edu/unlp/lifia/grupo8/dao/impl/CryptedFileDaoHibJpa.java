package ar.edu.unlp.lifia.grupo8.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.lifia.grupo8.dao.CryptedFileDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;




@Transactional 
public class CryptedFileDaoHibJpa extends GenericDaoHibernateImpl<CryptedFile> implements CryptedFileDao, java.io.Serializable {
	
	
	  
	
	private static final long serialVersionUID = 1L;
	
		@SuppressWarnings("unchecked")
				public List<CryptedFile> findByOwner(String owner){
					List<CryptedFile> resultado;
					Query query = this.getCurrentSession().createQuery("SELECT cf FROM CryptedFile cf WHERE cf.owner.username = :owner");
					query.setParameter("owner", owner);
					resultado= (List<CryptedFile>) query.list();
					try{
						return resultado; //si no se repiten los nombres uniqueResult()
					}catch(NoResultException nre ) {  
				        return null;  
			    }
		}
				@SuppressWarnings("unchecked")
				public List<CryptedFile> findByName(String name){
					Query q = this.getCurrentSession().createQuery("SELECT cf FROM CryptedFile cf WHERE cf.name = :name");
					q.setParameter("name", name);
					List<CryptedFile> r = (List<CryptedFile>) q.list();
					try{
						return r; //si no se repiten los nombres uniqueResult()
					}catch(NoResultException nre ) {
						return null;
					}
				}
				 
				@SuppressWarnings("unchecked")
				public List<CryptedFile> findAllFilesDifferentOwner(String username){
					Query q = this.getCurrentSession().createQuery("SELECT cf FROM CryptedFile cf WHERE cf.owner. username != :username");
					q.setParameter("username", username);
					List<CryptedFile> result = (List<CryptedFile>) q.list();
					try {
					return result;
					}catch (NoResultException nre ) {
						return null;
					}					
				}
					
				public CryptedFile findByNameAndOwner (String name1, String owner1){
					Query q1 = this.getCurrentSession().createQuery("SElECT cf FROM CryptedFile cf WHERE cf.owner.username = :owner AND cf.name = :name");
					q1.setParameter("name", name1);
					q1.setParameter("owner", owner1);
					
					try{
						return (CryptedFile) q1.uniqueResult();	
					}catch(NoResultException nre ) {
						return null;
					}
				    } 
					
				}	
				
		        
				
				
		




package ar.edu.unlp.lifia.grupo8.dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.lifia.grupo8.dao.GenericDao;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


@Transactional
public class GenericDaoHibernateImpl<T> implements GenericDao<T> {
	private Class<T> domainClass;	

	private SessionFactory sessionFactory;

	
	public GenericDaoHibernateImpl() {}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession(){
		return this.getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getDomainClass() {
	   if (domainClass == null) {
		   ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
		   domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
	   }
	  return domainClass;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T save(T entity) throws HibernateException{
		return (T) this.getCurrentSession().save(entity);
	}

	@Override
	public void delete(T entity) throws HibernateException{
		this.getCurrentSession().delete(entity);
	}

	@Override
	public T update(T entity) throws HibernateException, MySQLIntegrityConstraintViolationException{
		this.getCurrentSession().update(entity);
		return entity;
	}
	
	@Override
	public T merge(T entity) throws HibernateException{
		this.getCurrentSession().merge(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) throws HibernateException{
		return (T) this.getCurrentSession().get(getDomainClass(),id);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() throws HibernateException{
		return this.getCurrentSession().createQuery("FROM " + this.getDomainClass().getName()).list();		
	}

	@Override
	public T saveOrupdate(T entity) throws HibernateException,
			MySQLIntegrityConstraintViolationException {
		this.getCurrentSession().saveOrUpdate(entity);
		return entity;
	}	
	
	
}

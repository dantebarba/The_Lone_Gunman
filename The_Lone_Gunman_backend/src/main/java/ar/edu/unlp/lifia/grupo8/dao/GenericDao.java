package ar.edu.unlp.lifia.grupo8.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


/*
 * Define la interface que sera super interfaz de todas, para ello utiliza genericos
 */
public interface GenericDao<T>{
	
	public T save(T entity) throws HibernateException;
	public void delete(T entity) throws HibernateException;
	public T update(T entity) throws HibernateException, MySQLIntegrityConstraintViolationException;
	public T merge(T entity) throws HibernateException;
	public T findById(Serializable id) throws HibernateException;	
	public List<T> list() throws HibernateException;
	public T saveOrupdate(T entity) throws HibernateException, MySQLIntegrityConstraintViolationException;
}


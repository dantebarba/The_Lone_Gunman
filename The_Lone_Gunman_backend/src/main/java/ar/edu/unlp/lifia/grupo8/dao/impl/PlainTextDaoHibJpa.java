package ar.edu.unlp.lifia.grupo8.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.lifia.grupo8.dao.PlainTextDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;


@Transactional
public class PlainTextDaoHibJpa extends GenericDaoHibernateImpl<CryptedFile> implements PlainTextDao, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8404994417681399073L;

	
	
}

package ar.edu.unlp.lifia.grupo8.dao.impl;

import ar.edu.unlp.lifia.grupo8.dao.ImageDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;

public class ImageDaoHibJpa extends GenericDaoHibernateImpl<CryptedFile> implements ImageDao, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 551674253588369563L;

}

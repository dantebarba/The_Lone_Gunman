package ar.edu.unlp.lifia.grupo8.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.lifia.grupo8.dao.RankDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.rank.Rank;

@Transactional
public class RankDaoHibJpa extends GenericDaoHibernateImpl<Rank> implements
		RankDao, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536247503798582289L;

}

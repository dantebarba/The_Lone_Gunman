package ar.edu.unlp.lifia.grupo8.services.impl;


import ar.edu.unlp.lifia.grupo8.services.RankService;
import ar.edu.unlp.lifia.grupo8.dao.RankDao;

public class RankServiceImpl implements RankService, java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7429849360894926523L;
	private RankDao rankDao;
	
	
	public RankServiceImpl() {}
	
	
	/**
	 * @return the rankDao
	 */
	public RankDao getRankDao() {
		return rankDao;
	}

	/**
	 * @param rankDao the rankDao to set
	 */
	public void setRankDao(RankDao rankDao) {
		this.rankDao = rankDao;
	}

	

}

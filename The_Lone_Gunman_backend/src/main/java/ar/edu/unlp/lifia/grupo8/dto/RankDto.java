package ar.edu.unlp.lifia.grupo8.dto;






public class RankDto implements ResponseDto, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -902311702653692650L;
	
	private int id;
	private String rankName;
	
	public RankDto() {}
	
	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	/**
	 * @return the rankName
	 */
	public String getRankName() {
		return rankName;
	}




	/**
	 * @param rankName the rankName to set
	 */
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}



	
}

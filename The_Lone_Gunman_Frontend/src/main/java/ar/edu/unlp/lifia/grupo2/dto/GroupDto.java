package ar.edu.unlp.lifia.grupo2.dto;



public class GroupDto implements ResponseDto, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5300089563997543474L;
	
	private int id;
	private String name;
	private String description;
	private String leader;

	public GroupDto() {}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the leader
	 */
	public String getLeader() {
		return leader;
	}

	/**
	 * @param leader the leader to set
	 */
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	
}

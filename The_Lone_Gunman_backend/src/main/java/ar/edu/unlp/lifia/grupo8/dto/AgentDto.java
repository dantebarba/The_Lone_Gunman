package ar.edu.unlp.lifia.grupo8.dto;





public class AgentDto implements ResponseDto, java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -902314652653692650L;
	
	private int id;
	private String name;
	private String surname;
	private String email;
	private String username;
	private String password;
	private String state;
	private RankDto rank;
	private String role;
	private String group;

	public AgentDto() {}
	
	
	
	
	public int getId() {
		return id;
	}




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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}




	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}




	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}




	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}



	/**
	 * @return the rankDto
	 */
	public RankDto getRank() {
		return rank;
	}




	/**
	 * @param rankDto the rankDto to set
	 */
	public void setRank(RankDto rank) {
		this.rank = rank;
	}




	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}




	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}




	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}




	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	
}

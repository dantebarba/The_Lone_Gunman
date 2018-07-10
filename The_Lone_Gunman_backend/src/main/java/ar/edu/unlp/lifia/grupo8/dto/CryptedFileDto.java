package ar.edu.unlp.lifia.grupo8.dto;

public class CryptedFileDto implements ResponseDto,java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1850123843877459906L;
	
	
	private int id;
	private String name;
	private AgentDto owner;
	private StringBuffer file;
	//private String authenticationType;
	//
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
	 * @return the owner
	 */
	public AgentDto getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(AgentDto owner) {
		this.owner = owner;
	}
	/**
	 * @return the file
	 */
	public StringBuffer getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(StringBuffer file) {
		this.file = file;
	}
	

}

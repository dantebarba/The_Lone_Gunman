package ar.edu.unlp.lifia.grupo8.domain.file;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRule;
import ar.edu.unlp.lifia.grupo8.domain.agent.Agent;
import ar.edu.unlp.lifia.grupo8.domain.auth.AuthenticationType;

public abstract class CryptedFile {
	
	private int id;
	private StringBuffer file;
	private String name;
	private Date dateOfCreation;
	private String description;
	private Long sizeInKiloBytes;
	private Agent owner;
	private AuthenticationType authenticationType;
	private List<AccessRule> accessRules = new ArrayList<AccessRule>();
	
	
	public CryptedFile() {}
	
	
	
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
	 * @return the dateOfCreation
	 */
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	/**
	 * @param dateOfCreation the dateOfCreation to set
	 */
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
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
	public StringBuffer getFile() {
		return file;
	}
	public void setFile(StringBuffer file) {
		this.file = file;
	}
	public Long getSizeInKiloBytes() {
		return sizeInKiloBytes;
	}
	public void setSizeInKiloBytes(Long sizeInKiloBytes) {
		this.sizeInKiloBytes = sizeInKiloBytes;
	}
	public Agent getOwner() {
		return owner;
	}
	public void setOwner(Agent owner) {
		this.owner = owner;
	}
	public AuthenticationType getAuthenticationType() {
		return authenticationType;
	}
	public void setAuthenticationType(AuthenticationType authenticationType) {
		this.authenticationType = authenticationType;
	}
	public List<AccessRule> getAccessRules() {
		return accessRules;
	}
	public void setAccessRules(List<AccessRule> accessRules) {
		this.accessRules = accessRules;
	}
	/**
	 * @return the content
	 */
	abstract public void getContent();
	/**
	 * @param content the content to set
	 */
	abstract public void setContent(String content);
	
	
}

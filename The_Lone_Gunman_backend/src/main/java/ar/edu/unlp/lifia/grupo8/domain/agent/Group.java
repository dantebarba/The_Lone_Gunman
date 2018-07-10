package ar.edu.unlp.lifia.grupo8.domain.agent;

import java.util.Collection;

import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessByGroup;
import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRule;
import ar.edu.unlp.lifia.grupo8.domain.accessrule.AccessRuleType;
import ar.edu.unlp.lifia.grupo8.domain.file.CryptedFile;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;
import ar.edu.unlp.lifia.grupo8.domain.rank.Rank;
import ar.edu.unlp.lifia.grupo8.domain.role.Role;

public class Group extends MessageReceptor implements AccessRuleType{
	
	
	private String name;
	private String description;
	private Role leader;
	private Collection<Role> members;
	private Collection<CryptedFile> files;
	
	public Group() {}
	
	public Group(Role leader){
		this.setLeader(leader);		
	}
	
	public Group(Role leader, String name, String description){
		this.leader = leader;
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the leader
	 */
	public Role getLeader() {
		return leader;
	}



	/**
	 * @param leader the leader to set
	 */
	public void setLeader(Role leader) {
		this.leader = leader;
	}



	/**
	 * @return the members
	 */
	public Collection<Role> getMembers() {
		return members;
	}


	/**
	 * @param members the members to set
	 */
	public void setMembers(Collection<Role> members) {
		this.members = members;
	}

	/**
	 * @return the files
	 */
	public Collection<CryptedFile> getFiles() {
		return files;
	}
	
	/**
	 * @param files the files to set
	 */	
	public void setFiles(Collection<CryptedFile> files) {
		this.files = files;
	}

	public void addAllMembers(Collection<Role> members){
		this.getMembers().clear();
		this.getMembers().addAll(members);
	}
	
	@Override
	public String toString() {	
		return this.getName() + " - " + this.getDescription();
	}
	
	@Override
	public AccessRule accessRuleType() {
		AccessRule accessRule = new AccessByGroup(this);  
		return accessRule;
	}
	
	@Override
	public Rank encodingType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean receiveMessage(CodedMessage message,
			Conversation conversation) {
		// TODO Auto-generated method stub
		return false;
	}
}

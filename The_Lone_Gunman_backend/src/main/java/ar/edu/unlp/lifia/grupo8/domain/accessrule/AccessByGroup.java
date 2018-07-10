package ar.edu.unlp.lifia.grupo8.domain.accessrule;

import ar.edu.unlp.lifia.grupo8.domain.agent.Group;

public class AccessByGroup extends AccessRule {

	private Group group;
	
	public AccessByGroup() {}
	
	public AccessByGroup(Group group) {
		this.setGroup(group);
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}

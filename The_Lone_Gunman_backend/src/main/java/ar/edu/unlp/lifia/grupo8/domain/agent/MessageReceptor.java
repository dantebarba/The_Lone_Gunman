package ar.edu.unlp.lifia.grupo8.domain.agent;

import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;
import ar.edu.unlp.lifia.grupo8.domain.rank.Rank;

public abstract class MessageReceptor {
	
	private int id;
	
	public MessageReceptor() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Rank encodingType(){
		return null;
	}
	

	public abstract boolean receiveMessage(CodedMessage message,
			Conversation conversation);
	
	public abstract String getName();
	
}

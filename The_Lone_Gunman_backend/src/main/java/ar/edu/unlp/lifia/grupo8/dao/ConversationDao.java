package ar.edu.unlp.lifia.grupo8.dao;

import java.util.List;

import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;

public interface ConversationDao extends GenericDao<Conversation>{
  
  public Conversation findConversationBySecretNameSenderAndReceiver(String secretNameSender, String secretNameReceiver);
  public List<CodedMessage> getCodedMessagesByUserNameSenderAndReceiver(String secretNameSender, String secretNameReceiver);

   
}

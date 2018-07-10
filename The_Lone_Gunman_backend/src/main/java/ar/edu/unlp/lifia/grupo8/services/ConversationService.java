package ar.edu.unlp.lifia.grupo8.services;

import java.util.List;

import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;
import ar.edu.unlp.lifia.grupo8.dto.ConversationDto;

public interface ConversationService {
  
  public boolean saveConversation (ConversationDto conversation);
  
  public void updateConversation(Conversation conversation);

  public Conversation findConversationBySecretNameSenderAndReceiver(String secretNameSender, String secretNameReceiver);
  public List<CodedMessage> getCodedMessagesByUserNameSenderAndReceiver(String secretNameSender, String secretNameReceiver);

  public void saveOrUpdate(Conversation conversation);

}

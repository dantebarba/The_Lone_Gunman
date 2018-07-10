package ar.edu.unlp.lifia.grupo8.domain.agent;

import java.util.ArrayList;
import java.util.Collection;

import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;

public class Conversation {

  private Long id;
  private String secretNameSender;
  private String secretNameReceiver; // Puede ser un agente o un grupo, suponiendo que un agente nunca se puede llamar de la misma manera que un grupo.
  private Collection<CodedMessage> messages;

  
  public Conversation() {
  }
  
  public Conversation(String secretNameSender, String secretNameReceiver) {
    this.setSecretNameReceiver(secretNameReceiver);
    this.setSecretNameSender(secretNameSender);
    this.setMessages(new ArrayList<CodedMessage>());
  }
  
  public String getSecretNameSender() {
    return secretNameSender;
  }

  public void setSecretNameSender(String secretNameSender) {
    this.secretNameSender = secretNameSender;
  }

  public String getSecretNameReceiver() {
    return secretNameReceiver;
  }

  public void setSecretNameReceiver(String secretNameReceiver) {
    this.secretNameReceiver = secretNameReceiver;
  }

  public Collection<CodedMessage> getMessages() {
    return messages;
  }

  public void setMessages(Collection<CodedMessage> messages) {
    this.messages = messages;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}

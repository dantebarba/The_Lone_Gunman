package ar.edu.unlp.lifia.grupo8.dto;

import java.util.List;


public class ConversationDto implements ResponseDto{
  
  private Long id;
  private String secretNameSender;
  private String secretNameReceiver; // Puede ser un agente o un grupo, suponiendo que un agente nunca se puede llamar de la misma manera que un grupo.
  private List<CodedMessageDto> messages;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<CodedMessageDto> getMessages() {
    return messages;
  }

  public void setMessages(List<CodedMessageDto> messages) {
    this.messages = messages;
  }

}

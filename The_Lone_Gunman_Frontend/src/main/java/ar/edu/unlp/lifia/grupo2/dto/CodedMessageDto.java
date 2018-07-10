package ar.edu.unlp.lifia.grupo2.dto;

import java.io.Serializable;
import java.util.Date;

public class CodedMessageDto implements ResponseDto,Serializable {
  
  private static final long serialVersionUID = -90231465265369265L;
  private int id;
  private AgentDto receptor;
  private AgentDto sender;
  private String subject;
  private String content;
  private Date date;
  
  
  

  /**
   * @return the content
   */
  public String getContent() {
      return content;
  }
  /**
   * @param content the content to set
   */
  public void setContent(String content) {
      this.content = content;
  }
  public String getSubject() {
      return subject;
  }
  public void setSubject(String subject) {
      this.subject = subject;
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
   * @return the date
   */
  public Date getDate() {
      return date;
  }
  /**
   * @param date the date to set
   */
  public void setDate(Date date) {
      this.date = date;
  }
  public AgentDto getSender() {
    return sender;
  }
  public void setSender(AgentDto sender) {
    this.sender = sender;
  }
  public AgentDto getReceptor() {
    return receptor;
  }
  public void setReceptor(AgentDto receptor) {
    this.receptor = receptor;
  }
  
}

package ar.edu.unlp.lifia.grupo8.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlp.lifia.grupo8.dao.ConversationDao;
import ar.edu.unlp.lifia.grupo8.dao.generic.GenericDaoHibernateImpl;
import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;

@Transactional
public class ConversationDaoHibJpa extends GenericDaoHibernateImpl<Conversation> implements ConversationDao {


  @Override
  public Conversation findConversationBySecretNameSenderAndReceiver(String secretNameSender, String secretNameReceiver) {
      
      try {
        Conversation conversation = (Conversation) this.getCurrentSession().getNamedQuery("Conversation.getConversationForSecretNameReceiverAndSender").setString(secretNameSender, "secretNameSender").setString(secretNameReceiver, "secretNameReceiver").uniqueResult();
        return conversation;
      } catch(NoResultException nre ) {  
        return null;  
      }
  
  }
  
  @SuppressWarnings("unchecked")
public List<CodedMessage> getCodedMessagesByUserNameSenderAndReceiver(String secretNameSender, String secretNameReceiver){
        try {
       List<CodedMessage> messages = (List<CodedMessage>) this.getCurrentSession().getNamedQuery("Conversation.getCodedMessagesByUserNameSenderAndReceiver").setString(secretNameSender, "secretNameSender").setString(secretNameReceiver, "secretNameReceiver").list();
        return messages;
      } catch(NoResultException nre ) {  
        return null;  
      }
}

}
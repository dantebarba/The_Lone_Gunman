package ar.edu.unlp.lifia.grupo8.services.impl;

import java.util.List;

import org.hibernate.HibernateException;

import ar.edu.unlp.lifia.grupo8.dao.ConversationDao;
import ar.edu.unlp.lifia.grupo8.domain.agent.Conversation;
import ar.edu.unlp.lifia.grupo8.domain.message.CodedMessage;
import ar.edu.unlp.lifia.grupo8.dto.ConversationDto;
import ar.edu.unlp.lifia.grupo8.services.ConversationService;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ConversationServiceImpl implements ConversationService {
  
    ConversationDao conversationDao;

  @Override
  public boolean saveConversation(ConversationDto conversation) {
    // TODO Auto-generated method stub
    return false;
  }


  @Override
  public void updateConversation(Conversation conversation) {
        try {
			conversationDao.update(conversation);
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
  }

  @Override
  public void saveOrUpdate(Conversation conversation) {
        try {
			conversationDao.saveOrupdate(conversation);
		} catch (MySQLIntegrityConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
  }

  public Conversation findConversationBySecretNameSenderAndReceiver(String secretNameSender, String secretNameReceiver){
	 return conversationDao.findConversationBySecretNameSenderAndReceiver(secretNameSender, secretNameReceiver);
  }

  public List<CodedMessage> getCodedMessagesByUserNameSenderAndReceiver(String secretNameSender, String secretNameReceiver){
	  return conversationDao.getCodedMessagesByUserNameSenderAndReceiver(secretNameSender, secretNameReceiver);
  }
}

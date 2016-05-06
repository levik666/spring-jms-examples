package com.levik.jms.producer;

import java.time.LocalDateTime;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
public class MessageProducer {
    
    private JmsTemplate jmsTemplate;

    private final static int MAX_NUMBER_OF_MESSAGE = 2;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendMessages(String destinationName, String messageType) throws JMSException {
		if ("text".equalsIgnoreCase(messageType)) {
			sendTextMessages(destinationName);
		} else if ("bytes".equalsIgnoreCase(messageType)) {
			sendBytesMessages(destinationName);
		} else if ("map".equalsIgnoreCase(messageType)) {
			sendMapMessages(destinationName);
		} else if ("object".equalsIgnoreCase(messageType)) {
			sendObjectMessages(destinationName);
		}
	}

	public void sendTextMessages(String destinationName) throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < MAX_NUMBER_OF_MESSAGE; i++) {
            buffer.append("Message '").append(i).append("' sent at: ").append(LocalDateTime.now());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(destinationName, session -> {
                TextMessage message = session.createTextMessage(payload);
                message.setIntProperty("messageCount", count);
                log.info("Sending text message number '{}'", count);
                return message;
            });
        }
    }
	
	public void sendBytesMessages(String destinationName) throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < MAX_NUMBER_OF_MESSAGE; i++) {
            buffer.append("Message '").append(i).append("' sent at: ").append(LocalDateTime.now());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(destinationName, session -> {
                BytesMessage message = session.createBytesMessage();
                message.writeUTF(payload);
                message.setIntProperty("messageCount", count);
                log.info("Sending bytes message number '{}'", count);
                return message;
            });
        }
    }
	
	public void sendMapMessages(String destinationName) throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < MAX_NUMBER_OF_MESSAGE; i++) {
            buffer.append("Message '").append(i).append("' sent at: ").append(LocalDateTime.now());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(destinationName, session -> {
                MapMessage message = session.createMapMessage();
                message.setString("payload", payload);
                message.setIntProperty("messageCount", count);
                log.info("Sending map message number '{}'", count);
                return message;
            });
        }
    }
	
	public void sendObjectMessages(String destinationName) throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < MAX_NUMBER_OF_MESSAGE; i++) {
            buffer.append("Message '").append(i).append("' sent at: ").append(LocalDateTime.now());
            
            final int count = i;
            final String payloadStr = buffer.toString();
            final Payload payload = new Payload(payloadStr);
            
            jmsTemplate.send(destinationName, session -> {
                ObjectMessage message = session.createObjectMessage(payload);
                message.setIntProperty("messageCount", count);
                log.info("Sending object message number '{}'", count);
                return message;
            });
        }
    }
	
}

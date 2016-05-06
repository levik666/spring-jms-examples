package com.levik.jms.producer;

import java.time.LocalDateTime;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
public class SimpleMessageProducer {
    
    private JmsTemplate jmsTemplate;

    private final static int MAX_NUMBER_OF_MESSAGE = 5;
    
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send(String message) throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i <= MAX_NUMBER_OF_MESSAGE; i++) {
            buffer.append("Message '").append(message).append(i).append("' sent at: ").append(LocalDateTime.now());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(session -> {
                TextMessage textMessage = session.createTextMessage(payload);
                textMessage.setIntProperty("messageCount", count);
                log.info("Sending message number '{}'", count);
                return textMessage;
            });
        }
    }
}

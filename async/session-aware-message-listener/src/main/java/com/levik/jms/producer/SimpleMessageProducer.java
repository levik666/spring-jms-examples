package com.levik.jms.producer;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
public class SimpleMessageProducer {
    
    protected int numberOfMessages = 100;
    
    protected JmsTemplate jmsTemplate; 
    
    protected Queue replyToDestination;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setReplyToDestination(Queue replyToDestination) {
		this.replyToDestination = replyToDestination;
	}

	public void sendMessages() throws JMSException {
        final StringBuilder buffer = new StringBuilder(); 
        
        for (int i = 0; i < numberOfMessages; ++i) {
            buffer.append("Message '").append(i).append("' sent at: ").append(new Date());
            
            final int count = i;
            final String payload = buffer.toString();
            
            jmsTemplate.send(session -> {
                TextMessage message = session.createTextMessage(payload);
                message.setJMSReplyTo(replyToDestination);
                log.info("Sending request message number '{}'", count);
                return message;
            });
        }
    }
}

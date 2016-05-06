package com.levik.jms.listener;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

@Slf4j
public class MySessionAwareMessageListener implements SessionAwareMessageListener<Message> {
    
	@Override
	public void onMessage(Message message, Session session) throws JMSException {
        try {
            log.info("Received message: {}", ((TextMessage)message).getText());
            
            // Send a reply message 
            StringBuilder buffer = new StringBuilder("Reply message sent at: ").append(new Date());
            TextMessage newMessage = session.createTextMessage(buffer.toString());
            MessageProducer producer =  session.createProducer(message.getJMSReplyTo());
            log.info("Sending reply message");
            producer.send(newMessage);
        } catch (JMSException e) {
            log.error(e.getMessage(), e);
        }
		
	}

}

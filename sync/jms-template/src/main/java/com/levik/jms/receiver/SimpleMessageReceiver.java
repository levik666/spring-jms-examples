package com.levik.jms.receiver;

import javax.jms.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleMessageReceiver {
    
	@Autowired
    protected JmsTemplate jmsTemplate;
	
	public Message receiveMessage() {
		Message message = jmsTemplate.receive();
		log.debug("Received a JMS message: {}", message);
		return message;
    }
	
	public String receiveAndConvert() {
		String message = (String) jmsTemplate.receiveAndConvert();
		log.debug("Received a text message: {}", message);
		return message;
	}

}

package com.levik.jms.producer;

import javax.jms.JMSException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleMessageProducer {
    
    @Autowired
    protected JmsTemplate jmsTemplate;

	
	public void convertAndSendMessages(String payload) throws JMSException {
        jmsTemplate.convertAndSend(payload);
        log.info(payload);
    }
	
	public void send(String payload) throws JMSException {
        jmsTemplate.send(session -> session.createTextMessage(payload));
        log.info(payload);
	}
	
}

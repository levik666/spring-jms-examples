package com.levik.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleMessageListener implements MessageListener {
    
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            log.info("========================================================");
            log.info("Received message: {}", textMessage.getText());
            log.info("Perform acknowledge");
            textMessage.acknowledge();
            log.info("========================================================");
        } catch (JMSException e) {
            log.error(e.getMessage(), e);
        }
    }

}

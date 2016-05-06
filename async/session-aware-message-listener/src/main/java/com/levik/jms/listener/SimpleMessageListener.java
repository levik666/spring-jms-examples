package com.levik.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class SimpleMessageListener implements MessageListener {
    
    public void onMessage(Message message) {
        try {
            log.info("Received reply message: {}", ((TextMessage)message).getText());
        } catch (JMSException e) {
            log.error(e.getMessage(), e);
        }
    }

}

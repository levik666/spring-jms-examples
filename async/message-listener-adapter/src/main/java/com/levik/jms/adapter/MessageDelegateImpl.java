package com.levik.jms.adapter;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class MessageDelegateImpl implements MessageDelegate {
    
    public void processMessage(TextMessage message) {
        try {
            log.info("Consumed text message number {}", message.getIntProperty("messageCount"));
        } catch (JMSException e) {
            log.error(e.getMessage(), e);
        }
    }
    
    public void processMessage(BytesMessage message) {
        try {
            log.info("===============================!!!!====================================");
            log.info("Consumed bytes message number {}", message.getIntProperty("messageCount"));
            log.info("===============================!!!!====================================");
        } catch (JMSException e) {
            log.error(e.getMessage(), e);
        }
    }
    
    public void processMessage(MapMessage message) {
        try {
            log.info("======================================================================");
            log.info("Consumed map message number {}", message.getIntProperty("messageCount"));
            log.info("======================================================================");
        } catch (JMSException e) {
            log.error(e.getMessage(), e);
        }
    }
    
    public void processMessage(ObjectMessage message) {
        try {
            log.info("Consumed object message number {}", message.getIntProperty("messageCount"));
        } catch (JMSException e) {
            log.error(e.getMessage(), e);
        }
    }
}

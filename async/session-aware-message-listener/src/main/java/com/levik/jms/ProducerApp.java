package com.levik.jms;

import javax.jms.JMSException;

import com.levik.jms.producer.SimpleMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerApp {
	
    public static void main(String[] args) throws JMSException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("/home/levik/work/spring-jms-examples/async/session-aware-message-listener/src/main/resources/producer-jms-context.xml", ProducerApp.class);
        SimpleMessageProducer producer = (SimpleMessageProducer) context.getBean("messageProducer");
        producer.sendMessages();
    }
    
}

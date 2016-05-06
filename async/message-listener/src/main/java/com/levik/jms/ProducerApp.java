package com.levik.jms;

import javax.jms.JMSException;

import com.levik.jms.producer.SimpleMessageProducer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerApp {
	
    public static void main(String[] args) throws JMSException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("jms-context.xml", ProducerApp.class);
        SimpleMessageProducer producer = (SimpleMessageProducer) context.getBean("messageProducer");
        producer.send("Test Message");
    }
    
}

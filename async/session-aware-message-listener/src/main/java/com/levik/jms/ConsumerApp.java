package com.levik.jms;

import javax.jms.JMSException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApp {
	
    public static void main(String[] args) throws JMSException {
    	new ClassPathXmlApplicationContext("/home/levik/work/spring-jms-examples/async/session-aware-message-listener/src/main/resources/consumer-jms-context.xml", ConsumerApp.class);
    }
    
}

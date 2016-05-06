package com.levik.jms;

import javax.jms.JMSException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerApp {
	
    public static void main(String[] args) throws JMSException {
    	new ClassPathXmlApplicationContext("jms-context.xml", ConsumerApp.class);
    }
    
}

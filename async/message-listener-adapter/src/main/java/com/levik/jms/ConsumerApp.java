package com.levik.jms;

import javax.jms.JMSException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class ConsumerApp {
	
    public static void main(String[] args) throws JMSException {
    	new ClassPathXmlApplicationContext("jms-context.xml", ConsumerApp.class);
    }
    
}

package com.levik.jms;

import javax.jms.JMSException;

import com.levik.jms.producer.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerApp {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProducerApp.class);

    public static void main(String[] args) throws JMSException {
    	String destinationName = null;
    	String messageType = null;
    	
    	if (args.length == 2) {
    		destinationName = args[0];
    		messageType = args[1];
			LOG.debug("Using arguments destinationName: {}  messageType: {}", destinationName, messageType);
		} else {
			LOG.error("There must be two arguments, destinationName and messageType");
		}
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("jms-context.xml", ProducerApp.class);
        MessageProducer producer = (MessageProducer) context.getBean("messageProducer");
        producer.sendMessages(destinationName, messageType);
    }
    
}

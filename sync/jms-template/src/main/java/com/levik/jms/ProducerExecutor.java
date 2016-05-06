package com.levik.jms;

import javax.jms.JMSException;

import com.levik.jms.producer.SimpleMessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerExecutor {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProducerExecutor.class);

    public static void main(String[] args) throws JMSException {
    	String message = null;
    	
    	if (args.length > 0 && null != args[0] && !"".equals(args[0])) {
			message = args[0];
    	}
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("jms-context.xml", ProducerExecutor.class);
        SimpleMessageProducer producer = (SimpleMessageProducer) context.getBean("messageProducer");
        producer.send(message);
    }
    
}

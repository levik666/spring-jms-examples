package com.levik.jms;

import javax.jms.JMSException;

import com.levik.jms.receiver.SimpleMessageReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class ConsumerExecutor {
	
    public static void main(String[] args) throws JMSException {
    	String receiveType = null;
    	
    	if (args.length > 0 && null != args[0] && !"".equals(args[0])) {
    		receiveType = args[0];
    	}
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("jms-context.xml", ConsumerExecutor.class);
    	SimpleMessageReceiver receiver = context.getBean(SimpleMessageReceiver.class);
        log.debug("Using the '{}' receiveType", receiveType);
        
    	for (int i = 0; i <= 100; i++) {
			log.debug(receiver.receiveAndConvert());
    	}
    }
    
}

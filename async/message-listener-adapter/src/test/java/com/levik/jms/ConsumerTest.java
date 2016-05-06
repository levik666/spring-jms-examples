package com.levik.jms;

import com.levik.jms.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;

@Slf4j
public class ConsumerTest {

    private static final String PATH = "jms-context.xml";

    private MessageProducer messageProducer;

    private static final String DESTINATION_NAME = "Q1";
    private static final String DESTINATION_NAME_SECOND = "TEST.FOO2";

    @Before
    public void setup(){
        final ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
        messageProducer = context.getBean(MessageProducer.class);
    }

    @Test
    public void sendMessageTest() throws JMSException {
        messageProducer.sendMessages(DESTINATION_NAME, "bytes");
        messageProducer.sendMapMessages(DESTINATION_NAME_SECOND);

    }

}

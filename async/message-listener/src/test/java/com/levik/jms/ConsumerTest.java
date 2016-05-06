package com.levik.jms;

import com.levik.jms.producer.SimpleMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;
import java.time.LocalDateTime;

@Slf4j
public class ConsumerTest {

    private static final String PATH = "jms-context.xml";

    private SimpleMessageProducer simpleMessageProducer;

    private static final String MESSAGE = "Simple text -> " + LocalDateTime.now();

    @Before
    public void setup(){
        final ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
        simpleMessageProducer = context.getBean(SimpleMessageProducer.class);
    }

    @Test
    public void sendMessageTest() throws JMSException {
        simpleMessageProducer.send(MESSAGE);
    }

}

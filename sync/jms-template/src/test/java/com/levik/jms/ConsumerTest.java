package com.levik.jms;

import com.levik.jms.producer.SimpleMessageProducer;
import com.levik.jms.receiver.SimpleMessageReceiver;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;
import javax.jms.Message;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@Slf4j
public class ConsumerTest {

    private static final String PATH = "jms-context.xml";

    private SimpleMessageProducer simpleMessageProducer;
    private SimpleMessageReceiver simpleMessageReceiver;

    private static final String FIRST_MESSAGE = "Simple Message using send -> " + LocalDateTime.now();
    private static final String SECOND_MESSAGE = "Simple Message using convertAndSend -> " + LocalDateTime.now();

    @Before
    public void setup(){
        final ApplicationContext context = new ClassPathXmlApplicationContext(PATH);
        simpleMessageProducer = context.getBean(SimpleMessageProducer.class);
        simpleMessageReceiver = context.getBean(SimpleMessageReceiver.class);
    }

    @Test
    public void sendMessageUsingSendTest() throws JMSException {
        simpleMessageProducer.send(FIRST_MESSAGE);
    }

    @Test
    public void sendMessageUsingCovertAndSendTest() throws JMSException {
        simpleMessageProducer.convertAndSendMessages(SECOND_MESSAGE);
    }

    @Test
    public void receiverMessage(){
        Message message = simpleMessageReceiver.receiveMessage();
        assertNull("Can't receive any message ", message);
    }

    @Test
    public void receiverString() throws JMSException {
        simpleMessageProducer.send(FIRST_MESSAGE);

        log.info("======================================");

        String message = simpleMessageReceiver.receiveAndConvert();
        assertNotNull("Message should be received ", message);
    }

}

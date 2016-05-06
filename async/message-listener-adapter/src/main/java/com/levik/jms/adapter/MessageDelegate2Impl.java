package com.levik.jms.adapter;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class MessageDelegate2Impl implements MessageDelegate2 {
    
    public void processMessage(String message) {
    	log.info("Consumed text message number {}", message);
    }
    
    public void processMessage(byte[] message) {
        log.info("=============================???=======================================");
    	log.info("Consumed bytes message number {}", message);
        log.info("=============================???=======================================");
    }
    
    public void processMessage(Map message) {
        log.info("======================================================================");
    	log.info("Consumed map message number -> {}", message);
        log.info("======================================================================");
    }
    
    public void processMessage(Object message) {
    	log.info("Consumed object message number {}", message);
    }
}

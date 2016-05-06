package com.levik.jms.adapter;

import java.util.Map;

public interface MessageDelegate2 {

    void processMessage(String message);

    void processMessage(byte[] message);

    void processMessage(Map message);

    void processMessage(Object message);

}
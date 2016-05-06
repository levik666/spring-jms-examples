package com.levik.jms.adapter;

import javax.jms.BytesMessage;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

public interface MessageDelegate {

    void processMessage(TextMessage message);

    void processMessage(BytesMessage message);

    void processMessage(MapMessage message);

    void processMessage(ObjectMessage message);

}
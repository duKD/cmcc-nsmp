package com.ultrapower.controller.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.util.Map;

public class MessageConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        Map<String,String> unserialize = (Map<String,String>)SerializeUtil.unserialize(message.getBody());
        System.out.println("消息出队："+unserialize);
    }

}

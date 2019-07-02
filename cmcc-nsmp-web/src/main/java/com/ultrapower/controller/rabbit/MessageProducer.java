package com.ultrapower.controller.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
@Component
public class MessageProducer {
    @Resource
    AmqpTemplate amqpTemplate;

    public void sendMessage(Object message) {
        System.out.println("消息入队："+message);
        amqpTemplate.convertAndSend("queueTestKey", message);
    }

}

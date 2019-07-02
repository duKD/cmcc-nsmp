package com.ultrapower.controller.rabbit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/applicationContext-rabbitmq.xml")
public class RabbitMqTest {

    @Autowired
    MessageProducer messageProducer;

    @Test
    public void testProducer(){
        Map<String,String> message = new HashMap();
        message.put("name","杜小美");
        message.put("age","3");
        messageProducer.sendMessage(SerializeUtil.serialize(message));
    }
}

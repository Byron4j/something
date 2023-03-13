package org.byron4j.bootaction.rabbit.demo02;

import org.byron4j.bootaction.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQSender4Obj {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user){
        System.out.println("MQSender4Obj send:" + user);
        amqpTemplate.convertAndSend("objectQueue", user);
    }
}

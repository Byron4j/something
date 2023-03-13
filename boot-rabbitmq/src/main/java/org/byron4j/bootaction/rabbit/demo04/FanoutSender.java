package org.byron4j.bootaction.rabbit.demo04;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "This is fanout msg";
        System.out.println("send msg is :" + context);
        amqpTemplate.convertAndSend("fanoutExchange", "",  context);
    }
}

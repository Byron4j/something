package org.byron4j.bootaction.rabbit.demo01;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQSenderA {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Object object){
        System.out.println("MQSenderA-->发送的内容为：" + object);
        // routingKey和发送的队列一致
        amqpTemplate.convertAndSend("queue01", object);
    }
}

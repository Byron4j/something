package org.byron4j.bootaction.rabbit.demo03;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.b")
public class RabbitMQListenerB {
    @RabbitHandler
    public void process(Object object){
        System.out.println("RabbitMQListenerB-->" + object);
    }
}

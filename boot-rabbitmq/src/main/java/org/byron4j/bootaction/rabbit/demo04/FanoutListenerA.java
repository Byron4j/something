package org.byron4j.bootaction.rabbit.demo04;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.a")
public class FanoutListenerA {
    @RabbitHandler
    public void process(Object object){
        System.out.println("FanoutListenerA-->" + object);
    }
}

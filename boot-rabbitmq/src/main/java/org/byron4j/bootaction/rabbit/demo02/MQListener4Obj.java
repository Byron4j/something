package org.byron4j.bootaction.rabbit.demo02;

import org.byron4j.bootaction.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "objectQueue")
public class MQListener4Obj {

    @RabbitHandler
    public void process(User user){
        System.out.println("MQListener4Obj receive:" + user);
    }
}

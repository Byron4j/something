package org.byron4j.bootaction.rabbit.demo05;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RabbitListener(queues = "delayQueue")
public class DelayReceiver {
    @RabbitHandler
    public void receive(Object object){
        System.out.println("接收时间：" + LocalDateTime.now());
        System.out.println("接收内容为：" + object);
    }
}

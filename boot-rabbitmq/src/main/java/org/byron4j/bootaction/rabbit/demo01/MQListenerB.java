package org.byron4j.bootaction.rabbit.demo01;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"queue01"})  // 队列在config中已经声明
public class MQListenerB {

    @RabbitHandler  // 接收消息处理方法
    public void receiveMsg(Object msg){
        System.out.println("MQListenerB--->" + msg);
    }
}

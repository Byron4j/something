package org.byron4j.bootaction.rabbit.demo05;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DelaySender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Object obj){
        System.out.println("发送时间：" + LocalDateTime.now());
        rabbitTemplate.convertAndSend("delayExchange","delayQueue", obj, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 设置延迟属性
                message.getMessageProperties().setHeader(MessageProperties.X_DELAY, 10000);
                return message;
            }
        });
    }
}

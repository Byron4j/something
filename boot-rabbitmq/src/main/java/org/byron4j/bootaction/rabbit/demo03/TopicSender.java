package org.byron4j.bootaction.rabbit.demo03;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String topic = "topic";
        System.out.println("sender:" + topic);
        amqpTemplate.convertAndSend("topicExchange", "topic.c", topic);
    }

    public void sendA(){
        String topic = "topic A";
        System.out.println("sender:" + topic);
        amqpTemplate.convertAndSend("topicExchange", "topic.a", topic);
    }

    public void sendB(){
        String topic = "topic B";
        System.out.println("sender:" + topic);
        amqpTemplate.convertAndSend("topicExchange", "topic.b", topic);
    }
}

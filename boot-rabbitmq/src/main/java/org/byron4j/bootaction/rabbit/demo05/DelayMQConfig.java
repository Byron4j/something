package org.byron4j.bootaction.rabbit.demo05;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayMQConfig {

    @Bean
    public CustomExchange delayExchange(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        // 延迟消息： x-delayed-message
        return new CustomExchange("delayExchange", "x-delayed-message",
                true, false, args);
    }

    @Bean
    public Queue delayQueue(){
        return new Queue("delayQueue");
    }

    @Bean
    public Binding bindingDelay(Queue delayQueue, Exchange delayExchange){
        return BindingBuilder.bind(delayQueue).to(delayExchange).with("delayQueue").noargs();
    }
}

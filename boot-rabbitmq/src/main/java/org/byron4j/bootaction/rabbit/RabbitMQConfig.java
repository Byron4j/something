package org.byron4j.bootaction.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // 声明一个消息队列
    @Bean
    public Queue queue(){
        return new Queue("queue01");
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("objectQueue");
    }


    // topic 模式配置
    // 队列
    @Bean
    public Queue queueMsgA(){
        return new Queue("topic.a");
    }
    @Bean
    public Queue queueMsgB(){
        return new Queue("topic.b");
    }
    // exchange
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }
    //绑定关系  *表示一个单词 #表示1或多个单词
    // 绑定 topic.a
    @Bean
    public Binding bindingTopic(Queue queueMsgA, TopicExchange topicExchange){
        return BindingBuilder.bind(queueMsgA).to(topicExchange).with("topic.a");
    }
    // 绑定topic.#
    @Bean
    public Binding bindingTopics(Queue queueMsgB, TopicExchange topicExchange){
        return BindingBuilder.bind(queueMsgB).to(topicExchange).with("topic.#");
    }

    // 广播模式
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    public Queue fanoutQueueA(){
        return new Queue("fanout.a");
    }
    @Bean
    public Queue fanoutQueueB(){
        return new Queue("fanout.b");
    }
    @Bean
    public Binding bindingFanoutQueueA(Queue fanoutQueueA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }
    @Bean
    public Binding bindingFanoutQueueB(Queue fanoutQueueB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }
}

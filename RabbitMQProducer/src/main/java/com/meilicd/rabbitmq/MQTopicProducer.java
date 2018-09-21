package com.meilicd.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by hanyingqiang on 2018/9/20.
 */
@Component
@Configuration
public class MQTopicProducer {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Bean(name = "queueA")
    public Queue queueA(){
        return new Queue("topic.queue.a");
    }

    @Bean(name = "queueB")
    public Queue queueB(){
        return new Queue("topic.queue.b");
    }

    @Bean(name = "topicExchange")
    public TopicExchange exchange(){
        return new TopicExchange("topic.exchange");
    }

    @Bean
    Binding bindingExchangeQueueA(@Qualifier("queueA") Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("topic.#");
    }

    @Bean
    Binding bindingExchangeQueueB(@Qualifier("queueB") Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("topic.queue.b");
    }


    public void topic(String routingKey,User user){
        amqpTemplate.convertAndSend("topic.exchange",routingKey,user);
    }
}

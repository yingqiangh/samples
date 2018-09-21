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
public class MQFanoutProducer {
    @Bean(name = "fanoutQueueA")
    Queue queueA(){
        return new Queue("fanout.queue.a");
    }
    @Bean(name = "fanoutQueueB")
    Queue queueB(){
        return new Queue("fanout.queue.b");
    }
    @Bean(name = "fanoutQueueC")
    Queue queueC(){
        return new Queue("fanout.queue.c");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout.exchange");
    }

    @Bean
    Binding bindingQueueA(@Qualifier("fanoutQueueA") Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    Binding bindingQueueB(@Qualifier("fanoutQueueB") Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
    @Bean
    Binding bindingQueueC(@Qualifier("fanoutQueueC") Queue queue,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Autowired
    AmqpTemplate amqpTemplate;
    public void fanout(User user){
        amqpTemplate.convertAndSend("fanout.exchange","",user);
    }
}

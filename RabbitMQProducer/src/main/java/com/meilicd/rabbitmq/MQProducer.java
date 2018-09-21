package com.meilicd.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hanyingqiang on 2018/9/19.
 */
@Component
public class MQProducer {
    @Autowired
    AmqpTemplate amqpTemplate;
    public void direct(Object msg){
        amqpTemplate.convertAndSend("direct.queue",msg);
    }
}

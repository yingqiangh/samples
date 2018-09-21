package com.meilicd.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hanyingqiang on 2018/9/19.
 */
@Component
public class MQReceiver {
    @RabbitListener(queues = "direct.queue")
    public void direct(User msg){
        System.out.println(msg.getName());
    }
}

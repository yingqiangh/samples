package com.meilicd.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hanyingqiang on 2018/9/20.
 */
@Component
public class MQTopicConsumer {
    @RabbitListener(queues = "topic.queue.a")
    public void queueA(User user){
        System.out.println("queueA:"+user.getName());
    }

    @RabbitListener(queues = "topic.queue.b")
    public void queueB(User user){
        System.out.println("queueB:"+user.getName());
    }
}

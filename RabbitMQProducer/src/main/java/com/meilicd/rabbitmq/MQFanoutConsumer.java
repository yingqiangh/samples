package com.meilicd.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by hanyingqiang on 2018/9/20.
 */
@Component
public class MQFanoutConsumer {
    @RabbitListener(queues = "fanout.queue.a")
    public void queueA(User user){
        System.out.println("QueueA:"+user.getName());
    }
    @RabbitListener(queues = "fanout.queue.b")
    public void queueB(User user){
        System.out.println("QueueB:"+user.getName());
    }

    @RabbitListener(queues = "fanout.queue.c")
    public void queueC(User user){
        System.out.println("QueueC:"+user.getName());
    }

}

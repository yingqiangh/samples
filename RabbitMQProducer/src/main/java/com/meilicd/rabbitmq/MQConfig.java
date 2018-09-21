package com.meilicd.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hanyingqiang on 2018/9/19.
 */
@Configuration
public class MQConfig {
    @Bean
    public Queue queue(){
        return new Queue("direct.queue");
    }
}

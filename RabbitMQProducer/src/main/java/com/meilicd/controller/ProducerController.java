package com.meilicd.controller;

import com.meilicd.rabbitmq.MQFanoutProducer;
import com.meilicd.rabbitmq.MQProducer;
import com.meilicd.rabbitmq.MQTopicProducer;
import com.meilicd.rabbitmq.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hanyingqiang on 2018/9/19.
 */
@RestController
@RequestMapping("/msg")
public class ProducerController {
    @Autowired
    MQProducer mqProducer;

    @Autowired
    MQTopicProducer mqTopicProducer;

    @Autowired
    MQFanoutProducer mqFanoutProducer;

    @RequestMapping(value = "/direct",method = RequestMethod.POST)
    public String direct(String msg){
        mqProducer.direct(msg);
        return msg;
    }

    @RequestMapping(value = "/direct/user",method = RequestMethod.POST)
    public String direct(@RequestBody User user){
        System.out.println(user.getName());
        mqProducer.direct(user);
        return user.toString();
    }

    @RequestMapping(value = "/topic/user/{routingKey}",method = RequestMethod.POST)
    public String topic(@PathVariable("routingKey") String routingKey,
                        @RequestBody User user){
        mqTopicProducer.topic(routingKey,user);
        return user.toString();
    }

    @RequestMapping(value = "/fanout/user",method = RequestMethod.POST)
    public String fanout(@RequestBody User user){
        mqFanoutProducer.fanout(user);
        return user.toString();
    }
}

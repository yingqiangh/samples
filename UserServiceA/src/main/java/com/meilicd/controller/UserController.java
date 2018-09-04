package com.meilicd.controller;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import com.meilicd.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanyingqiang on 2018/8/17.
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    public UserDto getUser(@PathVariable("userId") Long userId){
        logger.info("getUser,userId:{}",userId);
        UserDto userDto = new UserDto();
        userDto.setId(userId);
        userDto.setUserName("Han IN A");
        return userDto;
    }
//
//    public static void main(String[] args){
//        while (true) {
//            System.out.println("=== one transaction ===");
//            Transaction transaction = Cat.newTransaction("MyType","UserServiceA-test");
//
//            try{
//                Cat.logEvent("URL.Server","192.168.4.5", Event.SUCCESS,"ip=192.168.4.5");
//                Cat.logMetricForCount("main.count");
//                Cat.logMetricForSum("main.sum",10);
//                transaction.setStatus(Transaction.SUCCESS);
//            }catch (Exception e){
//                transaction.setStatus(e);
//            }
//            transaction.complete();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
}

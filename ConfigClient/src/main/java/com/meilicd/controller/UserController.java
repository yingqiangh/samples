package com.meilicd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leon.Han on 18/8/18.
 */
@RestController
@RefreshScope
public class UserController {
    @Value("${defaultUserId}")
    private String defaultUserId;

    @RequestMapping(value = "/defaultUserId",method = RequestMethod.GET)
    public String defaultUserId(){
        System.out.print("defaultUserId");
        return defaultUserId;
    }
}

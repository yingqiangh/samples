package com.meilicd.controller;

import com.meilicd.client.UserClient;
import com.meilicd.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanyingqiang on 2018/8/17.
 */
@RestController
public class UserController {
    @Autowired
    UserClient userClient;

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public UserDto getUser(@RequestParam("userId") long userId){
        UserDto userDto = userClient.getUser(userId);

        return userDto;
    }
}

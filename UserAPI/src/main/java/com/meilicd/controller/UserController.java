package com.meilicd.controller;

import com.meilicd.client.UserClient;
import com.meilicd.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hanyingqiang on 2018/8/17.
 */
@RestController
public class UserController {
    @Autowired
    UserClient userClient;

    @RequestMapping(value = "getUser/{userId}",method = RequestMethod.GET)
    public UserDto getUser(@PathVariable("userId") long userId){
        UserDto userDto = userClient.getUser(userId);

        return userDto;
    }
}

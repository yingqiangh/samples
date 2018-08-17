package com.meilicd.controller;

import com.meilicd.dto.UserDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanyingqiang on 2018/8/17.
 */
@RestController
public class UserController {
    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    public UserDto getUser(@PathVariable("userId") Long userId){
        UserDto userDto = new UserDto();
        userDto.setId(userId);
        userDto.setUserName("Han IN A");
        return userDto;
    }
}

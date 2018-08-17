package com.meilicd;

import com.meilicd.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hanyingqiang on 2018/8/17.
 */
@RestController
public class HelloworldController {
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public UserDto say(){
        UserDto userDto = new UserDto();
        userDto.setId(1000);
        userDto.setUserName("Han Yingqiang");
        return userDto;
    }
}

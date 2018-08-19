package com.meilicd.client;

import com.meilicd.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * Created by Leon.Han on 2018/8/19.
 */
@Component
public class UserClientHystrix implements UserClient{
    @Override
    public UserDto getUser(Long userId) {
        UserDto userDto = new UserDto();
        userDto.setId(0);
        userDto.setUserName("default user");
        return userDto;
    }
}

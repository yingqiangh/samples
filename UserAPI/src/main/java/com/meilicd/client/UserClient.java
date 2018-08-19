package com.meilicd.client;

import com.meilicd.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hanyingqiang on 2018/8/17.
 */
@FeignClient(value = "user-service",fallback = UserClientHystrix.class)
@Component
public interface UserClient {
    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    UserDto getUser(@PathVariable("userId") Long userId);
}

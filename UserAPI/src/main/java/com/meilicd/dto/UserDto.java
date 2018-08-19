package com.meilicd.dto;

import lombok.Data;

/**
 * Created by hanyingqiang on 2018/8/17.
 */
@Data
public class UserDto {
    private String userName;
    private long id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

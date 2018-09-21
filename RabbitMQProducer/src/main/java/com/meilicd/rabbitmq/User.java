package com.meilicd.rabbitmq;

import java.io.Serializable;

/**
 * Created by hanyingqiang on 2018/9/19.
 */
public class User implements Serializable{
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

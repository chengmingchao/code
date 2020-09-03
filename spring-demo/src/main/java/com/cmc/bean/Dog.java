package com.cmc.bean;

import com.cmc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class Dog {
    public void shut(){
        System.out.println("汪");
    }

    @Resource
    UserServiceImpl service;

    public void test(){
        service.getUser();
    }

}

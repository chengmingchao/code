package com.cmc.factory;

import com.cmc.bean.User;

public class UserFactory {

    public  User getUser(){
        return new User();
    }
}

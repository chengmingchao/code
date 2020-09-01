package com.cmc.service;

import com.cmc.dao.UserDao;

public class UserServiceImpl implements Userservice {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}

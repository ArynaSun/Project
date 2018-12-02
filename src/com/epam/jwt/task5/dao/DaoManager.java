package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.dao.impl.UserDaoImpl;

public class DaoManager {

    private static final UserDao userDao = new UserDaoImpl();

    public static UserDao getUserDao() {
        return userDao;
    }
}

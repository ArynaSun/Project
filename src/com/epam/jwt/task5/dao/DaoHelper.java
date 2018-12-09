package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.dao.impl.CourseDaoImpl;
import com.epam.jwt.task5.dao.impl.UserDaoImpl;

public class DaoHelper {

    private static final UserDao userDao = new UserDaoImpl();
    private static final  CourseDao courseDao = new CourseDaoImpl();

    public static UserDao getUserDao() {
        return userDao;
    }

    public static CourseDao getCourseDao() {
        return courseDao;
    }
}

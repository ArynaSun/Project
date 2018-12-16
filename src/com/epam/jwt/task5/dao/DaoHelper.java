package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.impl.CourseDaoImpl;
import com.epam.jwt.task5.dao.impl.UserDaoImpl;

public class DaoHelper {

    private static final BaseDao<User, ?> userDao = new UserDaoImpl();
    private static final CourseDao COURSE_DAO = new CourseDaoImpl();

    public static BaseDao<User, ?> getUserDao() {
        return userDao;
    }

    public static CourseDao getCourseDao() {
        return COURSE_DAO;
    }
}

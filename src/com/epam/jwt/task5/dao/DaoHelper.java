package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.dao.impl.*;

public class DaoHelper {

    private static final BaseDao<User, ?> userDao = new UserDaoImpl();
    private static final BaseDao<Task, ?> taskDao = new TaskDaoImpl();
    private static final BaseDao<Subject, ?> subjectDao = new SubjectDaoImpl();
    private static final BaseDao<Solution, ?> solutionDao = new SolutionDaoImpl();
    private static final BaseDao<Review, ?> reviewDao = new ReviewDaoImpl();
    private static final BaseDao<Request, ?> requestDao = new RequestDaoImpl();
    private static final CourseDao courseDao = new CourseDaoImpl();

    public static BaseDao<User, ?> getUserDao() {
        return userDao;
    }

    public static BaseDao<Task, ?> getTaskDao() {
        return taskDao;
    }

    public static BaseDao<Subject, ?> getSubjectDao() {
        return subjectDao;
    }

    public static BaseDao<Solution, ?> getSolutionDao() {
        return solutionDao;
    }

    public static BaseDao<Review, ?> getReviewDao() {
        return reviewDao;
    }

    public static BaseDao<Request, ?> getRequestDao() {
        return requestDao;
    }

    public static CourseDao getCourseDao() {
        return courseDao;
    }
}

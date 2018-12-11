package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.dao.exception.DaoException;

public interface CourseDao extends BaseDao<Course>{
    void addStudentToCourse(int courseId, int studentId) throws DaoException;
}

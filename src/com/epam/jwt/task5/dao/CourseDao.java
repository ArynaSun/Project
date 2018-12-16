package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.dao.exception.DaoException;

import java.sql.ResultSet;

public interface CourseDao extends BaseDao<Course, ResultSet> {

    void addStudentToCourse(int courseId, int studentId) throws DaoException;
}

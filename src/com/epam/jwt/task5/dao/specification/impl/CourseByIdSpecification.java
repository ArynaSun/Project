package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.dao.specification.DaoSpecification;
import com.epam.jwt.task5.dao.exception.SpecificationException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseByIdSpecification implements DaoSpecification<Course, ResultSet> {

    private final int id;

    public CourseByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM course WHERE id = " + id;
    }

    @Override
    public List<Course> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Course> courseList = new ArrayList<>();
        Course course = null;
        try {
            if (resultSet.next()) {
                course = new Course();
                course.setId(id);
                course.setName(resultSet.getString(ColumnInfo.COURSE_NAME));
                course.setDescription(resultSet.getString(ColumnInfo.COURSE_DESCRIPTION));
                course.setStatusId(resultSet.getInt(ColumnInfo.COURSE_STATUS_ID));
                course.setSubjectId(resultSet.getInt(ColumnInfo.COURSE_SUBJECT_ID));
                course.setTeacherId(resultSet.getInt(ColumnInfo.COURSE_TEACHER_ID));
            }
        } catch (SQLException e) {
            throw new SpecificationException("Database Error", e);
        }
        courseList.add(course);

        return courseList;
    }
}

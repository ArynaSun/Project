package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesByStatusSpecification implements DaoSpecification<Course, ResultSet> {
    private final int statusId;

    public CoursesByStatusSpecification(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM course WHERE status_id = " + statusId;
    }

    @Override
    public List<Course> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Course> courseList = new ArrayList<>();
        Course course = null;

        try {
            if (resultSet.next()){
                course = new Course();
                course.setId(resultSet.getInt(ColumnInfo.COURSE_ID));
                course.setName(resultSet.getString(ColumnInfo.COURSE_NAME));
                course.setDescription(resultSet.getString(ColumnInfo.COURSE_DESCRIPTION));
                course.setTeacherId(resultSet.getInt(ColumnInfo.COURSE_TEACHER_ID));
                course.setSubjectId(resultSet.getInt(ColumnInfo.COURSE_SUBJECT_ID));
                course.setStatusId(statusId);
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);//todo
        }
        courseList.add(course);

        return courseList;
    }
}

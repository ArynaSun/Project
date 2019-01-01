package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.CourseStatus;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesByTeacherIdSpecification implements DaoSpecification<Course, ResultSet> {
    private final int teacherId;

    public CoursesByTeacherIdSpecification(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM course WHERE teacher_id = " + teacherId + " AND_SYMBOL status_id = " + CourseStatus.ACTIVE.getId();
    }

    @Override
    public List<Course> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Course> courseList = new ArrayList<>();
        Course course = null;

        try {
            while (resultSet.next()){
                course = new Course();

                course.setId(resultSet.getInt(ColumnInfo.COURSE_ID));
                course.setName(resultSet.getString(ColumnInfo.COURSE_NAME));
                course.setDescription(resultSet.getString(ColumnInfo.COURSE_DESCRIPTION));
                course.setTeacherId(teacherId);
                course.setSubjectId(resultSet.getInt(ColumnInfo.COURSE_SUBJECT_ID));
                course.setStatusId(resultSet.getInt(ColumnInfo.COURSE_STATUS_ID));

                courseList.add(course);
            }
        } catch (SQLException e) {
            throw new SpecificationException("Database Error", e);
        }

        return courseList;
    }
}

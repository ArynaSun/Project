package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesByStudentIdStatusIdSpecification implements DaoSpecification<Course, ResultSet> {
    private final int studentId;
    private final int statusId;

    public CoursesByStudentIdStatusIdSpecification(int studentId, int statusId) {
        this.studentId = studentId;
        this.statusId = statusId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM course WHERE id IN " +
                "(select distinct course_id from course_student_relation where student_id = "
                + studentId + ") AND status_id = " + statusId;
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
                course.setTeacherId(resultSet.getInt(ColumnInfo.COURSE_TEACHER_ID));
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

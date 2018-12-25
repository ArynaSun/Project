package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersByCourseIdSpecification implements DaoSpecification<User, ResultSet> {
    private final int courseId;

    public UsersByCourseIdSpecification(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM user WHERE id = " +
                "(select distinct student_id from course_student_relation where course_id = "
                + courseId + ")";
    }

    @Override
    public List<User> handleResult(ResultSet resultSet) throws SpecificationException {
        List<User> userList = new ArrayList<>();
        User user = null;
        try {
            while (resultSet.next()){
                user = new User();

                user.setName(resultSet.getString(ColumnInfo.USER_NAME));
                user.setId(resultSet.getInt(ColumnInfo.USER_ID));
                user.setRoleId(resultSet.getInt(ColumnInfo.USER_ROLE_ID));
                user.setEmail(resultSet.getString(ColumnInfo.USER_EMAIL));
                user.setPassword(resultSet.getString(ColumnInfo.USER_PASSWORD));

                userList.add(user);
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);//todo mes
        }

        return userList;
    }
}

package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.specification.DaoSpecification;
import com.epam.jwt.task5.dao.exception.SpecificationException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserByEmailSpecification implements DaoSpecification<User, ResultSet> {
    private final String email;

    public UserByEmailSpecification(String email) {
        this.email = email;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM user WHERE email = " + email;
    }

    @Override
    public List<User> handleResult(ResultSet resultSet) throws SpecificationException {
        List<User> userList = new ArrayList<>();
        User user = null;
        try {
            if(resultSet.next()){
                user = new User();
                user.setName(resultSet.getString(ColumnInfo.USER_NAME));
                user.setId(resultSet.getInt(ColumnInfo.USER_ID));
                user.setRoleId(resultSet.getInt(ColumnInfo.USER_ROLE_ID));
                user.setEmail(email);
                user.setPassword(resultSet.getString(ColumnInfo.USER_PASSWORD));
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);
        }

        userList.add(user);
        return userList;
    }
}

package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserByEmailPasswordSpecification implements DaoSpecification<User, ResultSet> {
    private final String email;
    private final String password;

    public UserByEmailPasswordSpecification(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM user WHERE email = " + email + " AND_SYMBOL password = " + password ;
    }

    @Override
    public List<User> handleResult(ResultSet resultSet) throws SpecificationException {
        List<User> userList = new ArrayList<>();
        User user = null;

        try {
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(ColumnInfo.USER_ID));
                user.setRoleId(resultSet.getInt(ColumnInfo.USER_ROLE_ID));
                user.setName(resultSet.getString(ColumnInfo.USER_NAME));
                user.setEmail(email);
                user.setPassword(password);
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);
        }

        userList.add(user);

        return userList;
    }
}

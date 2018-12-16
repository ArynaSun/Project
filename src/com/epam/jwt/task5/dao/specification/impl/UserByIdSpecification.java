package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserByIdSpecification implements DaoSpecification<User, ResultSet>  {
    private final int id;

    public UserByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM user WHERE id =" + id;
    }

    @Override
    public List handleResult(ResultSet result) throws SpecificationException {
        List<User> userList = new ArrayList<>();
        User user = null;

        try {
            if(result.next()){
                user = new User();
                user.setId(id);
                user.setName(result.getString(ColumnInfo.USER_NAME));
                user.setRoleId(result.getInt(ColumnInfo.USER_ROLE_ID));
                user.setEmail(result.getString(ColumnInfo.USER_EMAIL));
                user.setPassword(result.getString(ColumnInfo.USER_PASSWORD));
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);
        }

        userList.add(user);

        return userList;
    }
}

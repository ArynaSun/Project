package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersByRoleIdSpecification implements DaoSpecification<User, ResultSet> {
    private final int roleId;

    public UsersByRoleIdSpecification(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM user WHERE role_id = " + roleId;
    }

    @Override
    public List<User> handleResult(ResultSet result) throws SpecificationException {
        List<User> userList = new ArrayList<>();
        User user = null;

        try {
            while (result.next()){
                user = new User();
                user.setId(result.getInt(ColumnInfo.USER_ID));
                user.setName(result.getString(ColumnInfo.USER_NAME));
                user.setRoleId(roleId);
                user.setEmail(result.getString(ColumnInfo.USER_EMAIL));
                user.setPassword(result.getString(ColumnInfo.USER_PASSWORD));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);
        }

        return userList;
    }
}

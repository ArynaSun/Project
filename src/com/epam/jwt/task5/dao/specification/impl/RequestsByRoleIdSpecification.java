package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestsByRoleIdSpecification implements DaoSpecification<Request, ResultSet> {
    private final int roleId;

    public RequestsByRoleIdSpecification(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM request WHERE user_id IN (SELECT id FROM user WHERE role_id = " + roleId + ")";
    }

    @Override
    public List<Request> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Request> requestList= new ArrayList<>();
        Request request = null;

        try {
            while (resultSet.next()){
                request = new Request();

                request.setId(resultSet.getInt(ColumnInfo.REQUEST_ID));
                request.setStatusId(resultSet.getInt(ColumnInfo.REQUEST_STATUS_ID));
                request.setName(resultSet.getString(ColumnInfo.REQUEST_NAME));
                request.setUserId(resultSet.getInt(ColumnInfo.REQUEST_USER_ID));
                request.setCourseId(resultSet.getInt(ColumnInfo.REQUEST_COURSE_ID));

                requestList.add(request);
            }
        } catch (SQLException e) {
            throw new SpecificationException("Database Error", e);
        }

        return requestList;
    }
}

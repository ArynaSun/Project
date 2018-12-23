package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllRequestsSpecification implements DaoSpecification<Request, ResultSet> {

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM request";
    }

    @Override
    public List<Request> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Request> requestList = new ArrayList<>();
        Request request =  null;

        try {
            if (resultSet.next()){
                request = new Request();
                request.setId(resultSet.getInt(ColumnInfo.REQUEST_ID));
                request.setName(resultSet.getString(ColumnInfo.REQUEST_NAME));
                request.setStatusId(resultSet.getInt(ColumnInfo.REQUEST_STATUS_ID));
                request.setUserId(resultSet.getInt(ColumnInfo.REQUEST_USER_ID));
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);//todo message or other exception
        }
        requestList.add(request);

        return requestList;
    }
}

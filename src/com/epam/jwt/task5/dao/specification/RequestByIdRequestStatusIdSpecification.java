package com.epam.jwt.task5.dao.specification;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.impl.ColumnInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestByIdRequestStatusIdSpecification implements DaoSpecification<Request, ResultSet> {

    private final int roleId;
    private final int requestStatusId;

    public RequestByIdRequestStatusIdSpecification(int roleId, int requestStatusId) {
        this.roleId = roleId;
        this.requestStatusId = requestStatusId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM request WHERE user_id IN (SELECT id FROM user WHERE role_id = " + roleId
                + ") AND status_id = " + requestStatusId;
    }

    @Override
    public List<Request> handleResult(ResultSet result) throws SpecificationException {
        List<Request> requestList= new ArrayList<>();
        Request request = null;

        try {
            while (result.next()){
                request = new Request();

                request.setId(result.getInt(ColumnInfo.REQUEST_ID));
                request.setStatusId(result.getInt(ColumnInfo.REQUEST_STATUS_ID));
                request.setUserId(result.getInt(ColumnInfo.REQUEST_USER_ID));
                request.setName(result.getString(ColumnInfo.REQUEST_NAME));
                request.setCourseId(result.getInt(ColumnInfo.REQUEST_COURSE_ID));

                requestList.add(request);
            }
        } catch (SQLException e) {
            throw new SpecificationException("Database Error", e);
        }

        return requestList;
    }
}

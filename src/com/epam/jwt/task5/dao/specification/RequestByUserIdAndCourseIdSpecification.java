package com.epam.jwt.task5.dao.specification;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.impl.ColumnInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestByUserIdAndCourseIdSpecification implements DaoSpecification<Request, ResultSet> {

    private final int userId;
    private final int courseId;

    public RequestByUserIdAndCourseIdSpecification(int userId, int courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM request WHERE user_id = " + userId + " AND course_id = " + courseId;
    }

    @Override
    public List handleResult(ResultSet resultSet) throws SpecificationException {
        List<Request> requestList= new ArrayList<>();
        Request request = null;

        try {
            while (resultSet.next()){
                request = new Request();
                request.setId(resultSet.getInt(ColumnInfo.REQUEST_ID));
                request.setStatusId(resultSet.getInt(ColumnInfo.REQUEST_STATUS_ID));
                request.setName(ColumnInfo.REQUEST_NAME);
                request.setUserId(userId);
                request.setCourseId(courseId);
            }
        } catch (SQLException e) {
            throw new SpecificationException("Database Error", e);
        }
        requestList.add(request);

        return requestList;
    }
}

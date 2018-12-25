package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.bean.Review;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewsByStudentIdSpecification implements DaoSpecification<Review, ResultSet> {
    private final int studentId;

    public ReviewsByStudentIdSpecification(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM review WHERE student_id = " + studentId;
    }

    @Override
    public List<Review> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Review> reviewList= new ArrayList<>();
        Review review = null;

        try {
            while (resultSet.next()){
                review = new Review();

                review.setId(resultSet.getInt(ColumnInfo.REVIEW_ID));
                review.setStudentId(studentId);
                review.setCourseId(resultSet.getInt(ColumnInfo.REVIEW_COURSE_ID));
                review.setMark(resultSet.getInt(ColumnInfo.REVIEW_MARK));
                review.setDescription(resultSet.getString(ColumnInfo.REVIEW_DESCRIPTION));

                reviewList.add(review);
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);//todo message or other exception
        }

        return reviewList;
    }
}

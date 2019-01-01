package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Subject;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectByIdSpecification implements DaoSpecification<Subject, ResultSet> {
    private final int id;

    public SubjectByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM subject WHERE id = " + id;
    }

    @Override
    public List<Subject> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Subject> subjectList = new ArrayList<>();
        Subject subject = null;
        try {
            if (resultSet.next()) {
                subject = new Subject();
                subject.setId(id);
                subject.setName(resultSet.getString(ColumnInfo.SUBJECT_NAME));
            }
        } catch (SQLException e) {
            throw new SpecificationException("Database Error", e);
        }
        subjectList.add(subject);

        return subjectList;
    }
}

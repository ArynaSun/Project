package com.epam.jwt.task5.dao.specification;

import com.epam.jwt.task5.bean.Subject;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.impl.ColumnInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllSubjectsSpecification implements DaoSpecification<Subject, ResultSet> {
    @Override
    public String receiveInstruction() {
        return "SELECT * FROM subject";
    }

    @Override
    public List<Subject> handleResult(ResultSet result) throws SpecificationException {
        List<Subject> subjectList = new ArrayList<>();
        Subject subject = null;
        try {
            while (result.next()) {
                subject = new Subject();
                subject.setName(result.getString(ColumnInfo.SUBJECT_NAME));
                subject.setId(result.getInt(ColumnInfo.SUBJECT_ID));
                subjectList.add(subject);
            }
        } catch (SQLException e) {
            throw new SpecificationException("Database Error", e);
        }

        return subjectList;
    }
}

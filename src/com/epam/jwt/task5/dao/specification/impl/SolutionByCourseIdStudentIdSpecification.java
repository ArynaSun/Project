package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Solution;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionByCourseIdStudentIdSpecification implements DaoSpecification<Solution, ResultSet> {
    private final int courseId;
    private final int studentId;

    public SolutionByCourseIdStudentIdSpecification(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM solution WHERE task_id IN (SELECT task_id FROM task WHERE course_id = " +
                courseId + ")) AND student id = " + studentId;
    }

    @Override
    public List<Solution> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Solution> solutionList = new ArrayList<>();
        Solution solution = new Solution();

        try {
            if (resultSet.next()) {
                solution = new Solution();
                solution.setId(resultSet.getInt(ColumnInfo.SOLUTION_ID));
                solution.setStudentId(studentId);
                solution.setTaskId(resultSet.getInt(ColumnInfo.SOLUTION_TASK_ID));
                solution.setMark(resultSet.getInt(ColumnInfo.SOLUTION_MARK));
                solution.setAnswer(resultSet.getString(ColumnInfo.SOLUTION_ANSWER));
                solution.setAttachments(resultSet.getString(ColumnInfo.SOLUTION_ATTACHMENTS));
                solution.setAccepted(resultSet.getBoolean(ColumnInfo.SOLUTION_IS_ACCEPTED));
            }
        } catch (SQLException e) {
            throw new SpecificationException("Database Error", e);
        }

        solutionList.add(solution);

        return solutionList;
    }
}

package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Solution;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionByTaskIdSpecification implements DaoSpecification<Solution, ResultSet> {
    private final int taskId;

    public SolutionByTaskIdSpecification(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM solution WHERE task_id = " + taskId;
    }

    @Override
    public List<Solution> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Solution> solutionList = new ArrayList<>();
        Solution solution = null;

        try {
            if (resultSet.next()){
                solution = new Solution();
                solution.setId(resultSet.getInt(ColumnInfo.SOLUTION_ID));
                solution.setStudentId(resultSet.getInt(ColumnInfo.SOLUTION_STUDENT_ID));
                solution.setTaskId(taskId);
                solution.setMark(resultSet.getInt(ColumnInfo.SOLUTION_MARK));
                solution.setAnswer(resultSet.getString(ColumnInfo.SOLUTION_ANSWER));
                solution.setAttachments(resultSet.getString(ColumnInfo.SOLUTION_ATTACHMENTS));
                solution.setAccepted(resultSet.getBoolean(ColumnInfo.SOLUTION_IS_ACCEPTED));
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);//todo
        }

        solutionList.add(solution);

        return solutionList;
    }
}

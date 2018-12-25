package com.epam.jwt.task5.dao.specification.impl;

import com.epam.jwt.task5.bean.Task;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TasksByCourseIdSpecification implements DaoSpecification<Task, ResultSet> {
    private final int courseId;

    public TasksByCourseIdSpecification(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String receiveInstruction() {
        return "SELECT * FROM task WHERE course_id = " + courseId;
    }

    @Override
    public List<Task> handleResult(ResultSet resultSet) throws SpecificationException {
        List<Task> taskList = new ArrayList<>();
        Task task = null;

        try {
            while (resultSet.next()){
                task = new Task();
                task.setId(resultSet.getInt(ColumnInfo.TASK_ID));
                task.setCourseId(courseId);
                task.setName(resultSet.getString(ColumnInfo.TASK_NAME));
                task.setAttachments(resultSet.getString(ColumnInfo.TASK_ATTACHMENTS));
                task.setAssignmentDate(resultSet.getString(ColumnInfo.TASK_ASSIGNMENT_DATE));
                task.setDeadline(resultSet.getString(ColumnInfo.TASK_DEADLINE));

                taskList.add(task);
            }
        } catch (SQLException e) {
            throw new SpecificationException(e);//todo
        }


        return taskList;
    }
}

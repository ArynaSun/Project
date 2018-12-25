package com.epam.jwt.task5.dto;

import com.epam.jwt.task5.bean.Solution;
import com.epam.jwt.task5.bean.Task;

import java.io.Serializable;
import java.util.List;

public class TaskSolutionsDTO implements Serializable{
    private Task task;
    private List<Solution> solutions;

    public TaskSolutionsDTO() {
    }

    public TaskSolutionsDTO(Task task, List<Solution> solutions) {
        this.task = task;
        this.solutions = solutions;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}

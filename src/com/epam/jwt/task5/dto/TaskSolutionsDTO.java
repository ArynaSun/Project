package com.epam.jwt.task5.dto;

import com.epam.jwt.task5.bean.Solution;
import com.epam.jwt.task5.bean.Task;

import java.io.Serializable;
import java.util.List;

public class TaskSolutionsDTO implements Serializable{
    private Task task;
    private List<SolutionDTO> solutions;

    public TaskSolutionsDTO() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<SolutionDTO> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<SolutionDTO> solutions) {
        this.solutions = solutions;
    }
}

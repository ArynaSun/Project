package com.epam.jwt.task5.dto;

import com.epam.jwt.task5.bean.Task;

public class TaskDTO {
    private Task task;
    private String courseName;

    public TaskDTO() {
    }

    public TaskDTO(Task task, String courseName) {
        this.task = task;
        this.courseName = courseName;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

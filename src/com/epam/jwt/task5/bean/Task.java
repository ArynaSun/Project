package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Task implements Serializable{ //TODO override equals, hashCode, toString
    private int id;
    private int courseId;
    private String name;
    private String attachments;
    private String assignmentDate;
    private String deadline;

    public Task() {
    }

    public Task(int id, int courseId, String name, String attachments, String assignmentDate, String deadline) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.attachments = attachments;
        this.assignmentDate = assignmentDate;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}

package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Solution implements Serializable{//TODO override equals, hashCode, toString
    private int id;
    private int studentId;
    private int taskId;
    private int mark;
    private int statusId;
    private String answer;
    private String attachments;

    public Solution() {
    }

    public Solution(int id, int studentId, int taskId, int mark, int statusId, String answer, String attachments) {
        this.id = id;
        this.studentId = studentId;
        this.taskId = taskId;
        this.mark = mark;
        this.statusId = statusId;
        this.answer = answer;
        this.attachments = attachments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }
}

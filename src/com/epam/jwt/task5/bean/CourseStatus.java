package com.epam.jwt.task5.bean;

public class CourseStatus {//TODO EQ HA TOS

    private int id;
    private String statusName;

    public CourseStatus() {
    }

    public CourseStatus(int id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

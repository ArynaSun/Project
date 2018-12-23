package com.epam.jwt.task5.bean;

import java.io.Serializable;

public enum  CourseStatus implements Serializable{
    PLANNED(1, "Запланирован"), ACTIVE(2,"Активный"), COMPLETED(3, "Завершен");

    private final int id;
    private final String statusName;


    CourseStatus(int id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public int getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }
}

package com.epam.jwt.task5.bean;

import java.io.Serializable;

public enum Role implements Serializable { //TODO????
    ADMIN(0, "admin"), TEACHER(1, "teacher"), STUDENT(2, "student") ;

    private final int id;
    private final String name;

    Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

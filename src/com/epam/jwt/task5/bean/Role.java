package com.epam.jwt.task5.bean;

import java.io.Serializable;

public enum Role implements Serializable {
    ADMIN(0), TEACHER(1), STUDENT(2) ;

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

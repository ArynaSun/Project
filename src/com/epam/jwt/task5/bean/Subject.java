package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Subject implements Serializable {//TODO override equals, hashCode, toString
    private String name;
    private int id;

    public Subject() {
    }

    public Subject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

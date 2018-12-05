package com.epam.jwt.task5.bean;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {//TODO override equals, hashCode, toString
    private String name;
    private int id;
    private int teacherId;
    private int subjectId;

    public Course() {
    }

    public Course(String name, int id, int teacherId, int subjectId) {
        this.name = name;
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}

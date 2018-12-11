package com.epam.jwt.task5.bean;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    private String name;
    private String description;//TODO
    private int id;
    private int teacherId;
    private int subjectId;
    private int statusId;//TODO

    public Course() {
    }

    public Course(String name, String description, int id, int teacherId, int subjectId) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Course course = (Course) obj;

        if (null == name) {
            return (name == course.name);
        } else {
            if (!name.equals(course.name)) {
                return false;
            }
        }
        if (id != course.id) {
            return false;
        }
        if (teacherId != course.teacherId) {
            return false;
        }
        if (subjectId != course.subjectId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((name == null) ? 0 : (name.hashCode() * 11)) + (id * 31) + (teacherId * 13) + (subjectId * 17);
    }

    @Override
    public String toString(){
        return getClass().getName() + "name: " + name + ", id: " + id + ", teacherId: "
                + teacherId + ", subjectId: "  + subjectId;
    }
}

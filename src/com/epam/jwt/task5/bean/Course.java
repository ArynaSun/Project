package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private String description;
    private int id;
    private int teacherId;
    private int subjectId;
    private int statusId;

    public Course() {
    }

    public Course(String name, String description, int id, int teacherId, int subjectId, int statusId) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.statusId = statusId;
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
        if (null == description) {
            return (description == course.description);
        } else {
            if (!description.equals(course.description)) {
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
        if (statusId != course.statusId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((name == null) ? 0 : (name.hashCode() * 11)) +
                ((description == null) ? 0 : (description.hashCode() * 17)) + (id * 31) +
                (teacherId * 31)+ (statusId * 11) + (subjectId * 19);
    }

    @Override
    public String toString(){
        return getClass().getName() + "name: " + name + ", description: " + description + ", id: " + id + ", teacherId: "
                + teacherId +", statusId: " + statusId + ", subjectId: "  + subjectId;
    }
}

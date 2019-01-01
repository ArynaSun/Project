package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Request implements Serializable {
    private int id;
    private String name;
    private int userId;
    private int courseId;
    private int statusId;

    public Request() {
    }

    public Request(int id, String name, int userId, int courseId, int statusId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.courseId = courseId;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

        Request request = (Request) obj;

        if (null == name) {
            return (name == request.name);
        } else {
            if (!name.equals(request.name)) {
                return false;
            }
        }
        if (id != request.id) {
            return false;
        }
        if (userId != request.userId) {
            return false;
        }
        if (courseId != request.courseId) {
            return false;
        }
        if (statusId != request.statusId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((name == null) ? 0 : (name.hashCode() * 11)) + (id * 31) +
                (userId * 31)+ (statusId * 17) +(statusId * 19);
    }

    @Override
    public String toString(){
        return getClass().getName() + "name: " + name + ", id: " + id +
                ", statusId: " + statusId + ", courseId: " + courseId + ", userId: "  + userId;
    }
}

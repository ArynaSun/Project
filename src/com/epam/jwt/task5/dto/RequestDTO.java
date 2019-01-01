package com.epam.jwt.task5.dto;

import com.epam.jwt.task5.bean.Request;

public class RequestDTO {
    private Request request;
    private String userName;
    private String courseName;
    private String statusName;

    public RequestDTO() {
    }

    public RequestDTO(Request request, String userName, String courseName, String statusName) {
        this.request = request;
        this.userName = userName;
        this.courseName = courseName;
        this.statusName = statusName;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}

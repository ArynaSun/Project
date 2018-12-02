package com.epam.jwt.task5.service;

public enum JspPage {
    MAIN_PAGE("/jsp/mainPage.jsp"), INDEX_PAGE("/index.jsp");

    private final String path;

    JspPage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

package com.epam.jwt.task5.command;

public enum JspPage {
    INDEX_PAGE("/index.jsp", "localhost:8080/controller?command=index"),
    ADMIN_PAGE("WEB-INF/admin.jsp", "localhost:8080/controller?command=DISPLAY_ADMIN_PAGE");

    private final String path;
    private final String requestLine;

    JspPage(String path, String requestLine) {
        this.path = path;
        this.requestLine = requestLine;
    }

    public String getPath() {
        return path;
    }

    public String getRequestLine() {
        return requestLine;
    }
}

package com.epam.jwt.task5.command;

public enum JspPage {
    WELCOME_PAGE("/welcome_page.jsp", "localhost:8080/controller"),
    STUDENT_PAGE("WEB-INF/student_page.jsp","localhost:8080/controller?command=DISPLAY_STUDENT_PAGE"),
    TEACHER_PAGE("WEB-INF/teacher_page.jsp","localhost:8080/controller?command=DISPLAY_TEACHER_PAGE"),
    ERROR_PAGE("WEB-INF/error_page.jsp","localhost:8080/controller?command=DISPLAY_ERROR_PAGE"),
    COURSE_INFO("WEB-INF/course_info.jsp","localhost:8080/controller?command=DISPLAY_COURSE_INFO_PAGE"),
    STUDENT_INFO("WEB-INF/student_info.jsp","localhost:8080/controller?command=DISPLAY_STUDENT_INFO_PAGE"),
    ADMIN_PAGE("WEB-INF/admin_page.jsp", "localhost:8080/controller?command=DISPLAY_ADMIN_PAGE");

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

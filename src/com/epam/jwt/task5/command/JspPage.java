package com.epam.jwt.task5.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JspPage {
    public static final JspPage WELCOME_PAGE = new JspPage(
            "/WEB-INF/welcome_page.jsp", "http://localhost:8080/controller"),
    STUDENT_PAGE = new JspPage(
            "/WEB-INF/student_page.jsp","http://localhost:8080/controller?command=DISPLAY_STUDENT_PAGE"),
    TEACHER_PAGE = new JspPage(
            "/WEB-INF/teacher_page.jsp","http://localhost:8080/controller?command=DISPLAY_TEACHER_PAGE"),
    ADMIN_PAGE = new JspPage(
            "/WEB-INF/admin_page.jsp", "http://localhost:8080/controller?command=DISPLAY_ADMIN_PAGE"),
    ERROR_PAGE = new JspPage(
            "/WEB-INF/error_page.jsp","http://localhost:8080/controller?command=DISPLAY_ERROR_PAGE"),
    COURSE_INFO = new JspPage(
            "/WEB-INF/course_info.jsp","http://localhost:8080/controller?command=DISPLAY_COURSE_INFO_PAGE"),
    STUDENT_INFO = new JspPage(
            "/WEB-INF/student_info.jsp","http://localhost:8080/controller?command=DISPLAY_STUDENT_INFO_PAGE");
    public static final String AND_SYMBOL = "&";
    public static final String PARAMETRS_BEGINNING_SYMBOL = "?";
    public static final String EQUALS_SYMBOL = "=";

    private final String path;
    private final String requestLine;

    private JspPage(String path, String requestLine) {
        this.path = path;
        this.requestLine = requestLine;
    }

    /**
     Adds @parameter message to @field requestLine
     */
    public JspPage(JspPage page, String message) {
        this.path = page.getPath();

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameter.MESSAGE, message);

        this.requestLine = generateGetLine(params, page.getRequestLine());
    }

    public JspPage(JspPage page, String key, String value) {
        this.path = page.getPath();

        Map<String, String> params = new HashMap<>();
        params.put(key, value);

        this.requestLine = generateGetLine(params, page.getRequestLine());
    }

    public JspPage(JspPage page, Map<String, String> additionalParams) {
        this.path = page.path;
        this.requestLine = generateGetLine(additionalParams, page.requestLine);
    }

    private String generateGetLine(Map<String, String> additionalParams, String requestLine) {
        StringBuilder builder = new StringBuilder();
        builder.append(requestLine);

        Set<Map.Entry<String, String>> entries = additionalParams.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            if (!builder.toString().equals(WELCOME_PAGE.getRequestLine())){
                builder.append(AND_SYMBOL);
            } else {
                builder.append(PARAMETRS_BEGINNING_SYMBOL);
            }
            builder.append(entry.getKey())
                    .append(EQUALS_SYMBOL)
                    .append(entry.getValue());
        }
        return builder.toString();
    }

    public String getPath() {
        return path;
    }

    public String getRequestLine() {
        return requestLine;
    }
}

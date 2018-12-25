package com.epam.jwt.task5.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CourseCommand {
    String LOG_ERROR_MESSAGE = "Service Layer Exception";
    String SUCCESS_MESSAGE_KEY = "SUCCESS_MESSAGE";
    JspPage execute(HttpServletRequest request, HttpServletResponse response);
}

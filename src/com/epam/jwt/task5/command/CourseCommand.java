package com.epam.jwt.task5.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CourseCommand {
    JspPage execute(HttpServletRequest request, HttpServletResponse response);
}

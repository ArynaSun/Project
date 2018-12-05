package com.epam.jwt.task5.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CourseAction {
    JspPage carryOut(HttpServletRequest request, HttpServletResponse response);
}

package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestToRegistrationCommand implements CourseCommand {
    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}

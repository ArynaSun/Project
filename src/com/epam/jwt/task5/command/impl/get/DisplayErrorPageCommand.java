package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.util.PropertyHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayErrorPageCommand implements CourseCommand {

    private static final String ERROR_MESSAGE = "ERROR_MESSAGE";

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(JspAttribute.SERVER_MESSAGE, PropertyHelper.receiveMessage(ERROR_MESSAGE));

        return JspPage.ERROR_PAGE;
    }
}

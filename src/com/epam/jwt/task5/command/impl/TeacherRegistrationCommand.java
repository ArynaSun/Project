package com.epam.jwt.task5.command.impl;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeacherRegistrationCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(TeacherRegistrationCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter(RequestParameter.COURSE_NAME);
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);

        try {
            ServiceHelper.getAdminService().registerTeacher(name,email,password);
        } catch (ServiceException e) {
            logger.info(e.getMessage());//TODO ERROR_PAGE
        } catch (ValidationException e) {
           //TODO add validationMessage to response
        }

        return null; //TODO adminPage
    }
}

package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.StudentService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.util.PropertyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestToRegistrationCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(RequestToRegistrationCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        StudentService studentService = ServiceHelper.getStudentService();

        String name = request.getParameter(RequestParameter.REQUEST_NAME);
        String courseId = request.getParameter(RequestParameter.USER_ID);
        String userId = request.getParameter(RequestParameter.USER_ID);

        try {
            studentService.createRequest(name, userId, courseId);
            request.setAttribute(JspAttribute.SUCCESS_MESSAGE, PropertyHelper.receiveMessage(SUCCESS_MESSAGE_KEY));
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.ERROR_MESSAGE, e);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);

            return JspPage.ERROR_PAGE;
        }

        return JspPage.STUDENT_PAGE;
    }
}

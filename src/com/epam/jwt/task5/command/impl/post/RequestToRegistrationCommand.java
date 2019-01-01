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
import java.util.HashMap;
import java.util.Map;

public class RequestToRegistrationCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(RequestToRegistrationCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        StudentService studentService = ServiceHelper.getStudentService();

        String name = request.getParameter(RequestParameter.REQUEST_NAME);
        String courseId = request.getParameter(RequestParameter.USER_ID);
        String userId = request.getParameter(RequestParameter.USER_ID);

        JspPage jspPage;

        try {
            studentService.createRequest(name, userId, courseId);

            jspPage = new JspPage(JspPage.STUDENT_PAGE, PropertyHelper.receiveMessage(SUCCESS_MESSAGE_KEY));
        } catch (ValidationException e) {
            jspPage = new JspPage(JspPage.STUDENT_PAGE, e.getMessage());
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);

            jspPage = JspPage.ERROR_PAGE;
        }

        return jspPage;
    }
}

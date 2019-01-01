package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.util.PropertyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegistrationCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(StudentRegistrationCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter(RequestParameter.STUDENT_NAME);
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);

        JspPage jspPage;

        try {
            ServiceHelper.getStudentService().registerStudent(name, email, password);

            jspPage = new JspPage(JspPage.WELCOME_PAGE, PropertyHelper.receiveMessage(SUCCESS_MESSAGE_KEY));
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);

            jspPage =  JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            jspPage = new JspPage(JspPage.WELCOME_PAGE, e.getMessage());
        }

        return jspPage;
    }
}

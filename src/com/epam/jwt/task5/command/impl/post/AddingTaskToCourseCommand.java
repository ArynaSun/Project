package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.TeacherService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.util.PropertyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddingTaskToCourseCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(AddingTaskToCourseCommand.class);
    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        TeacherService teacherService = ServiceHelper.getTeacherService();

        String courseId = request.getParameter(RequestParameter.COURSE_ID);
        String name = request.getParameter(RequestParameter.TASK_NAME);
        String attachments = request.getParameter(RequestParameter.TASK_ATTACHMENTS);
        String assignmentDate = request.getParameter(RequestParameter.TASK_ASSIGNMENT_DATE);
        String deadline = request.getParameter(RequestParameter.TASK_DEADLINE);

        try {
            teacherService.createTask(courseId, name, attachments, assignmentDate, deadline );
            request.setAttribute(JspAttribute.SUCCESS_MESSAGE, PropertyHelper.receiveMessage(SUCCESS_MESSAGE_KEY));
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.ERROR_MESSAGE, e);
        }
        return JspPage.COURSE_INFO;
    }
}

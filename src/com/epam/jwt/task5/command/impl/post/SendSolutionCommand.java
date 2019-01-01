package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.bean.Course;
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

public class SendSolutionCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(SendSolutionCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        StudentService studentService = ServiceHelper.getStudentService();

        String studentId = request.getParameter(RequestParameter.STUDENT_ID);
        String taskId = request.getParameter(RequestParameter.TASK_ID);
        String mark = request.getParameter(RequestParameter.MARK);
        String answer = request.getParameter(RequestParameter.SOLUTION_ANSWER);
        String attachments = request.getParameter(RequestParameter.SOLUTION_ATTACHMENTS);
        String courseId = request.getParameter(RequestParameter.COURSE_ID);

        JspPage jspPage;
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put(RequestParameter.COURSE_ID, courseId);


        try {
            studentService.createSolution(studentId, taskId, mark, answer, attachments);

            stringMap.put(RequestParameter.MESSAGE, PropertyHelper.receiveMessage(SUCCESS_MESSAGE_KEY));

            jspPage = new JspPage(JspPage.COURSE_INFO, stringMap);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);

            jspPage = JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            stringMap.put(RequestParameter.MESSAGE, e.getMessage());
            jspPage = new JspPage(JspPage.COURSE_INFO, stringMap);
        }

        return jspPage;
    }
}

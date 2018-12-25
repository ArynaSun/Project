package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DisplayStudentInfoCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(DisplayStudentInfoCommand.class);
    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<Review> reviewList = new ArrayList<>();
        List<Course> completedCourseList = new ArrayList<>();
        User user;

        CommonService commonService = ServiceHelper.getCommonService();

        try {
            user = commonService.findUserById(request.getParameter(RequestParameter.STUDENT_ID));
            String studentId = String.valueOf(user.getId());

            reviewList = commonService.findReview(studentId);//TODO ASK TEACHER
            completedCourseList = commonService.findCoursesBy(user.getId(), CourseStatus.COMPLETED.getId());

            request.setAttribute(JspAttribute.COMPLETED_COURSES, completedCourseList);
            request.setAttribute(JspAttribute.STUDENT_REVIEW, reviewList);
            request.setAttribute(JspAttribute.STUDENT, user);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.ERROR_MESSAGE, e.getMessage());
        }

        return JspPage.STUDENT_INFO;
    }
}

package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.CourseStatus;
import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.SessionAttribute;
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

public class DisplayTeacherPageCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(DisplayWelcomePageCommand.class);
    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<Course> plannedCourseList = new ArrayList<>();
        List<Course> activeCourseList = new ArrayList<>();
        Course courseTeacher;

        CommonService commonService = ServiceHelper.getCommonService();
        try {
            User user = (User) request.getSession().getAttribute(SessionAttribute.USER);
            plannedCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.PLANNED.getId()));//TODO ASK TEACHER
            activeCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.PLANNED.getId()));//TODO ASK TEACHER
            courseTeacher = commonService.findCourseByTeacherId(user.getId());

            request.setAttribute(JspAttribute.PLANNED_COURSES, plannedCourseList);
            request.setAttribute(JspAttribute.ACTIVE_COURSES, activeCourseList);
            request.setAttribute(JspAttribute.TEACHER_COURSE, courseTeacher);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.ERROR_MESSAGE, e.getMessage());
        }

        return JspPage.TEACHER_PAGE;
    }
}

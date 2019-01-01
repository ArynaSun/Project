package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
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

public class DisplayAdminPageCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(DisplayAdminPageCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<Course> activeCourseList = new ArrayList<>();
        List<Course> plannedCourseList = new ArrayList<>();
        List<Course> completedCourseList = new ArrayList<>();
        List<User> teacherList = null;
        List<Request> studentRequestList = null;
        List<Request> teacherRequestList = null;

        CommonService commonService = ServiceHelper.getCommonService();

        try {
            activeCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.ACTIVE.getId()));//TODO ASK TEACHER
            plannedCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.PLANNED.getId()));//TODO ASK TEACHER
            completedCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.COMPLETED.getId()));//TODO ASK TEACHER
            teacherList = commonService.findUsersByRoleId(String.valueOf(Role.TEACHER.getId()));
            studentRequestList = commonService.findRequests(String.valueOf(Role.STUDENT.getId()));
            teacherRequestList = commonService.findRequests(String.valueOf(Role.TEACHER.getId()));

            request.setAttribute(JspAttribute.ACTIVE_COURSES, activeCourseList);
            request.setAttribute(JspAttribute.PLANNED_COURSES, plannedCourseList);
            request.setAttribute(JspAttribute.COMPLETED_COURSES, completedCourseList);
            request.setAttribute(JspAttribute.TEACHERS, teacherList);
            request.setAttribute(JspAttribute.STUDENT_REQUESTS, studentRequestList);
            request.setAttribute(JspAttribute.TEACHER_REQUESTS, teacherRequestList);

        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }

        return JspPage.ADMIN_PAGE;
    }
}

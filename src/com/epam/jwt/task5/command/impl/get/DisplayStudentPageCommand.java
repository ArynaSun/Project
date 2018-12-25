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
import com.epam.jwt.task5.service.StudentService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class DisplayStudentPageCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(DisplayStudentPageCommand.class);
    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<Course> courseList = new ArrayList<>();
        List<Course> studentCourseList = new ArrayList<>();

        CommonService commonService = ServiceHelper.getCommonService();
        try {
            User student = (User) request.getSession().getAttribute(SessionAttribute.USER);
            courseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.PLANNED.getId()));//TODO ASK TEACHER
            studentCourseList = commonService.findCoursesBy(student.getId(), CourseStatus.ACTIVE.getId());//todo get userId from session
            request.setAttribute(JspAttribute.PLANNED_COURSES, courseList);
            request.setAttribute(JspAttribute.STUDENT_COURSES, studentCourseList);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.ERROR_MESSAGE, e.getMessage());
        }


        return JspPage.STUDENT_PAGE;
    }
}

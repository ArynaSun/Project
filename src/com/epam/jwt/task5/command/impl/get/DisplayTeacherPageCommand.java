package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.CourseStatus;
import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.SessionAttribute;
import com.epam.jwt.task5.dto.CourseDTO;
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
        List<CourseDTO> plannedCourseDTOList = new ArrayList<>();

        List<Course> activeCourseList = new ArrayList<>();
        List<CourseDTO> activeCourseDTOList = new ArrayList<>();

        Course courseOfTeacher;
        CourseDTO courseOfTeacherDTO;

        CommonService commonService = ServiceHelper.getCommonService();
        try {
            User user = (User) request.getSession().getAttribute(SessionAttribute.USER);
            plannedCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.PLANNED.getId()));//TODO ASK TEACHER
            activeCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.ACTIVE.getId()));//TODO ASK TEACHER
            courseOfTeacher = commonService.findCourseByTeacherId(user.getId());

            for (Course course : plannedCourseList) {
                CourseDTO courseDTO = new CourseDTO();

                courseDTO.setCourse(course);
                courseDTO.setTeacherName(commonService.findUserById(String.valueOf(course.getTeacherId())).getName());
                courseDTO.setSubjectName(commonService.findSubjectById(String.valueOf(course.getSubjectId())).getName());

                plannedCourseDTOList.add(courseDTO);
            }

            for (Course course : activeCourseList) {
                CourseDTO courseDTO = new CourseDTO();

                courseDTO.setCourse(course);
                courseDTO.setSubjectName(commonService.findSubjectById(String.valueOf(course.getSubjectId())).getName());
                courseDTO.setTeacherName(commonService.findUserById(String.valueOf(course.getTeacherId())).getName());

                activeCourseDTOList.add(courseDTO);
            }

            if (courseOfTeacher != null) {
                courseOfTeacherDTO = new CourseDTO();
                courseOfTeacherDTO.setCourse(courseOfTeacher);
                courseOfTeacherDTO.setSubjectName(
                        commonService.findSubjectById(String.valueOf(courseOfTeacher.getSubjectId())).getName());
                courseOfTeacherDTO.setTeacherName(commonService.findUserById(
                        String.valueOf(courseOfTeacher.getTeacherId())).getName());
            } else {
                courseOfTeacherDTO = new CourseDTO();
                courseOfTeacherDTO.setCourse(new Course());
            }

            request.setAttribute(JspAttribute.PLANNED_COURSES, plannedCourseDTOList);
            request.setAttribute(JspAttribute.ACTIVE_COURSES, activeCourseDTOList);
            request.setAttribute(JspAttribute.COURSE_OF_TEACHER, courseOfTeacherDTO);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }

        return JspPage.TEACHER_PAGE;
    }
}

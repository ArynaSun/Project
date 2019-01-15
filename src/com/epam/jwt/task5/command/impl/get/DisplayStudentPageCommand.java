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

public class DisplayStudentPageCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(DisplayStudentPageCommand.class);
    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<Course> plannedCourseList = new ArrayList<>();
        List<CourseDTO> plannedCourseListDTO = new ArrayList<>();

        List<Course> studentCourseList = new ArrayList<>();
        List<CourseDTO> studentCourseListDTO = new ArrayList<>();

        CommonService commonService = ServiceHelper.getCommonService();
        try {
            User student = (User) request.getSession().getAttribute(SessionAttribute.USER);


            plannedCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.PLANNED.getId()));//TODO ASK TEACHER

            studentCourseList.addAll(commonService.findCoursesBy(student.getId(), CourseStatus.ACTIVE.getId()));
            studentCourseList.addAll(commonService.findCoursesBy(student.getId(), CourseStatus.PLANNED.getId()));
            studentCourseList.addAll(commonService.findCoursesBy(student.getId(), CourseStatus.COMPLETED.getId()));

            for (Course course : plannedCourseList) {
                CourseDTO courseDTO = new CourseDTO();

                courseDTO.setTeacherName(commonService.findUserById(String.valueOf(course.getTeacherId())).getName());
                courseDTO.setSubjectName(commonService.findSubjectById(String.valueOf(course.getSubjectId())).getName());
                courseDTO.setCourse(course);

                plannedCourseListDTO.add(courseDTO);
            }

            for (Course course : studentCourseList) {
                CourseDTO courseDTO = new CourseDTO();

                courseDTO.setTeacherName(commonService.findUserById(String.valueOf(course.getTeacherId())).getName());
                courseDTO.setCourse(course);
                courseDTO.setSubjectName(commonService.findSubjectById(String.valueOf(course.getSubjectId())).getName());

                studentCourseListDTO.add(courseDTO);
            }

            request.setAttribute(JspAttribute.PLANNED_COURSES, plannedCourseListDTO);
            request.setAttribute(JspAttribute.STUDENT_COURSES, studentCourseListDTO);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);

            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }


        return JspPage.STUDENT_PAGE;
    }
}

package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.dto.CourseDTO;
import com.epam.jwt.task5.dto.RequestDTO;
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
        List<CourseDTO> activeCourseListDTO = new ArrayList<>();

        List<Course> plannedCourseList = new ArrayList<>();
        List<CourseDTO> plannedCourseListDTO = new ArrayList<>();

        List<Course> completedCourseList = new ArrayList<>();
        List<CourseDTO> completedCourseListDTO = new ArrayList<>();

        List<User> teacherList = null;

        List<Request> studentRequestList = null;
        List<RequestDTO> studentRequestListDTO = new ArrayList<>();

        List<Request> teacherRequestList = null;
        List<RequestDTO> teacherRequestListDTO = new ArrayList<>();

        List<Subject> subjectList = new ArrayList<>();

        CommonService commonService = ServiceHelper.getCommonService();

        try {
            activeCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.ACTIVE.getId()));
            plannedCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.PLANNED.getId()));
            completedCourseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.COMPLETED.getId()));
            teacherList = commonService.findUsersByRoleId(String.valueOf(Role.TEACHER.getId()));

            studentRequestList = commonService.findRequests(String.valueOf(Role.STUDENT.getId()),
                    String.valueOf(RequestStatus.SENT.getId()));

            teacherRequestList = commonService.findRequests(String.valueOf(Role.TEACHER.getId()),
                    String.valueOf(RequestStatus.SENT.getId()));

            subjectList = commonService.findAllSubjects();

            initCourseDTO(activeCourseList, activeCourseListDTO, commonService);
            initCourseDTO(plannedCourseList, plannedCourseListDTO, commonService);
            initCourseDTO(completedCourseList, completedCourseListDTO, commonService);

            initRequestDTO(studentRequestList, studentRequestListDTO, commonService);
            initRequestDTO(teacherRequestList, teacherRequestListDTO, commonService);

            request.setAttribute(JspAttribute.ACTIVE_COURSES, activeCourseListDTO);
            request.setAttribute(JspAttribute.PLANNED_COURSES, plannedCourseListDTO);
            request.setAttribute(JspAttribute.COMPLETED_COURSES, completedCourseListDTO);
            request.setAttribute(JspAttribute.TEACHERS, teacherList);
            request.setAttribute(JspAttribute.SUBJECTS, subjectList);
            request.setAttribute(JspAttribute.STUDENT_REQUESTS, studentRequestListDTO);
            request.setAttribute(JspAttribute.TEACHER_REQUESTS, teacherRequestListDTO);

        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }

        return JspPage.ADMIN_PAGE;
    }
}

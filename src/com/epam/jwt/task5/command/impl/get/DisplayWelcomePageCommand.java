package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.CourseStatus;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.JspAttribute;
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

public class DisplayWelcomePageCommand implements CourseCommand {
    private static Logger logger = LogManager.getLogger(DisplayWelcomePageCommand.class);
    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<Course> courseList = new ArrayList<>();
        List<CourseDTO> plannedCourseListDTO = new ArrayList<>();

        CommonService commonService = ServiceHelper.getCommonService();
        try {
            courseList = commonService.findCoursesByStatusId(String.valueOf(CourseStatus.PLANNED.getId()));
            initCourseDTO(courseList, plannedCourseListDTO, commonService);
            request.setAttribute(JspAttribute.PLANNED_COURSES, plannedCourseListDTO);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }

        return JspPage.WELCOME_PAGE;
    }
}

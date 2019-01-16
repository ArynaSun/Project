package com.epam.jwt.task5.command.impl.get;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspAttribute;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.dto.CourseDTO;
import com.epam.jwt.task5.dto.ReviewDTO;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayStudentInfoCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(DisplayStudentInfoCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<Review> reviewList = new ArrayList<>();
        List<ReviewDTO> reviewListDTO = new ArrayList<>();

        List<Course> completedStudentCourseList = new ArrayList<>();
        List<CourseDTO> completedStudentCourseListDTO = new ArrayList<>();


        Map<String, String> map = new HashMap<>();

        User user;

        CommonService commonService = ServiceHelper.getCommonService();

        try {
            user = commonService.findUserById(request.getParameter(RequestParameter.STUDENT_ID));
            String studentId = String.valueOf(user.getId());

            map.put(RequestParameter.STUDENT_ID, studentId);

            reviewList = commonService.findReview(studentId);
            completedStudentCourseList = commonService.findCoursesBy(user.getId(), CourseStatus.COMPLETED.getId());

            initReviewDTO(reviewList, reviewListDTO, commonService);

            initCourseDTO(completedStudentCourseList, completedStudentCourseListDTO, commonService);

            request.setAttribute(JspAttribute.COMPLETED_COURSES, completedStudentCourseListDTO);
            request.setAttribute(JspAttribute.STUDENT_REVIEW, reviewListDTO);
            request.setAttribute(JspAttribute.STUDENT, user);

        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);

            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }

        return new JspPage(JspPage.STUDENT_INFO, map);
    }


}

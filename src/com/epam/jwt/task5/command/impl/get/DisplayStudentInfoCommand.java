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
import java.util.List;

public class DisplayStudentInfoCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(DisplayStudentInfoCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {
        List<Review> reviewList = new ArrayList<>();
        List<ReviewDTO> reviewListDTO = new ArrayList<>();

        List<Course> completedStudentCourseList = new ArrayList<>();
        List<CourseDTO> completedStudentCourseListDTO = new ArrayList<>();

        User user;

        CommonService commonService = ServiceHelper.getCommonService();

        try {
            user = commonService.findUserById(request.getParameter(RequestParameter.STUDENT_ID));
            String studentId = String.valueOf(user.getId());

            reviewList = commonService.findReview(studentId);//TODO ASK TEACHER
            completedStudentCourseList = commonService.findCoursesBy(user.getId(), CourseStatus.COMPLETED.getId());

            for (Review review : reviewList) {
                ReviewDTO reviewDTO = new ReviewDTO();

                reviewDTO.setReview(review);
                reviewDTO.setStudentName(commonService.findUserById(String.valueOf(review.getStudentId())).getName());
                reviewDTO.setCourseName(commonService.findCourse(String.valueOf(review.getCourseId())).getName());


                reviewListDTO.add(reviewDTO);
            }


            for (Course course : completedStudentCourseList) {
                CourseDTO courseDTO = new CourseDTO();

                courseDTO.setSubjectName(commonService.findSubjectById(String.valueOf(course.getSubjectId())).getName());
                courseDTO.setTeacherName(commonService.findUserById(String.valueOf(course.getTeacherId())).getName());
                courseDTO.setCourse(course);

                completedStudentCourseListDTO.add(courseDTO);
            }

            request.setAttribute(JspAttribute.COMPLETED_STUDENT_COURSES, completedStudentCourseListDTO);
            request.setAttribute(JspAttribute.STUDENT_REVIEW, reviewListDTO);
            request.setAttribute(JspAttribute.STUDENT, user);
        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);
            return JspPage.ERROR_PAGE;
        } catch (ValidationException e) {
            request.setAttribute(JspAttribute.SERVER_MESSAGE, e.getMessage());
        }

        return JspPage.STUDENT_INFO;
    }
}

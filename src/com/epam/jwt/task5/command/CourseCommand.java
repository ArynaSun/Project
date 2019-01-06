package com.epam.jwt.task5.command;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.bean.RequestStatus;
import com.epam.jwt.task5.bean.Review;
import com.epam.jwt.task5.dto.CourseDTO;
import com.epam.jwt.task5.dto.RequestDTO;
import com.epam.jwt.task5.dto.ReviewDTO;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CourseCommand {

    String LOG_ERROR_MESSAGE = "Service Layer Exception";
    String SUCCESS_MESSAGE_KEY = "SUCCESS_MESSAGE";

    JspPage execute(HttpServletRequest request, HttpServletResponse response);

    default void initCourseDTO(List<Course> activeCourseList, List<CourseDTO> plannedCourseListDTO,
                               CommonService commonService) throws ServiceException, ValidationException {//todo com serv
        for (Course course : activeCourseList) {
            CourseDTO courseDTO = new CourseDTO();

            courseDTO.setTeacherName(commonService.findUserById(String.valueOf(course.getTeacherId())).getName());
            courseDTO.setSubjectName(commonService.findSubjectById(String.valueOf(course.getSubjectId())).getName());

            plannedCourseListDTO.add(courseDTO);
            courseDTO.setCourse(course);
        }
    }

    default void initRequestDTO(List<Request> requestList, List<RequestDTO> requestListDTO,
                                CommonService commonService) throws ServiceException, ValidationException {
        for (Request request : requestList) {
            RequestDTO requestDTO = new RequestDTO();

            requestDTO.setRequest(request);
            requestDTO.setCourseName(commonService.findCourse(request.getCourseId()+"").getName());
            requestDTO.setUserName(commonService.findUserById(request.getUserId()+"").getName());//todo value of


            for (RequestStatus requestStatus : RequestStatus.values()) {
                if (requestStatus.getId() == request.getStatusId()){
                    requestDTO.setStatusName(requestStatus.getName());
                }
            }

            requestListDTO.add(requestDTO);
        }
    }

    default void initReviewDTO(List<Review> reviewList, List<ReviewDTO> reviewListDTO, CommonService commonService) throws ServiceException, ValidationException {
        for (Review review : reviewList) {
            ReviewDTO reviewDTO = new ReviewDTO();

            reviewDTO.setReview(review);
            reviewDTO.setStudentName(commonService.findUserById(String.valueOf(review.getStudentId())).getName());
            reviewDTO.setCourseName(commonService.findCourse(String.valueOf(review.getCourseId())).getName());


            reviewListDTO.add(reviewDTO);
        }
    }
}

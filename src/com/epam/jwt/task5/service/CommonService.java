package com.epam.jwt.task5.service;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;

import java.util.List;

public interface CommonService {
    User findUserById(String userId) throws ServiceException, ValidationException;

    List<Course> findCourses(String statusId) throws ServiceException, ValidationException;

    Course findCourse(String courseId) throws ServiceException, ValidationException;

    List<Task> findTasks(String courseId) throws ServiceException, ValidationException;

    List<Solution> findSolutions(String courseId, String studentId) throws ServiceException, ValidationException;

    List<Solution> findSolutions(String taskId) throws ServiceException, ValidationException;

    List<Request> findRequests() throws ServiceException, ValidationException;
}

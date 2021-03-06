package com.epam.jwt.task5.service;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;

import java.util.List;

public interface CommonService {
    User findUserById(String userId) throws ServiceException, ValidationException;

    List<User> findUsersByRoleId(String roleId) throws ServiceException, ValidationException;

    List<User> findStudentsBy(String courseId) throws ServiceException, ValidationException;

    List<Course> findCoursesByStatusId(String statusId) throws ServiceException, ValidationException;

    List<Course> findCoursesBy(int studentId, int statusId) throws ServiceException, ValidationException;

    List<Course> findCoursesByTeacherId(int teacherId) throws ServiceException, ValidationException;

    Course findCourse(String courseId) throws ServiceException, ValidationException;

    List<Task> findTasks(String courseId) throws ServiceException, ValidationException;

    List<Solution> findSolutions(String courseId, String studentId) throws ServiceException, ValidationException;

    List<Solution> findSolutions(String taskId) throws ServiceException, ValidationException;

    List<Request> findRequests(String roleId) throws ServiceException, ValidationException;

    List<Request> findRequests(String roleId, String requestStatusId) throws ServiceException, ValidationException;

    List<Review> findReview(String studentId) throws ServiceException, ValidationException;

    User findUserBy(String email, String password) throws ServiceException, ValidationException;

    Subject findSubjectById(String id) throws ServiceException, ValidationException;

    List<Subject> findAllSubjects() throws ServiceException;
}

package com.epam.jwt.task5.service;

import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;

public interface AdminService {
    void registerTeacher(String name, String email, String password) throws ServiceException, ValidationException;

    void addCourse(String name, String description, String teacherId, String subjectId)
            throws ServiceException, ValidationException;

    void addSubject(String name) throws ServiceException, ValidationException;

    void changeCourseTeacher(String courseId, String teacherId) throws ServiceException, ValidationException;

    void changeCourseStatus(String courseId, String statusId) throws ServiceException, ValidationException;

    void addStudentToCourse(String studentId, String courseId) throws ServiceException, ValidationException;
}

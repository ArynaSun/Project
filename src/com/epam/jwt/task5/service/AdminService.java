package com.epam.jwt.task5.service;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;

public interface AdminService {
    void registerTeacher(String name, String email, String password) throws ServiceException, ValidationException;

    void addCourse(String name,String description, String teacherId, String subjectId) throws ServiceException, ValidationException;
}

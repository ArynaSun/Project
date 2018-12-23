package com.epam.jwt.task5.service;

import com.epam.jwt.task5.bean.Solution;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.service.validator.UserValidator;

public interface StudentService extends UserService{
    void registerStudent(String name, String email, String password) throws ServiceException, ValidationException;

    void createSolution(String studentId, String taskId, String mark,
                            String answer, String attachments)
            throws ServiceException, ValidationException;
}

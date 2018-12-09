package com.epam.jwt.task5.service;

import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.service.validator.UserValidator;

public interface StudentService {
    void registerStudent(String name, String email, String password) throws ServiceException, ValidationException;
}

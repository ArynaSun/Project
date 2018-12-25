package com.epam.jwt.task5.service;

import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;

public interface UserService {
    void createRequest(String name, String userId, String courseId) throws ServiceException, ValidationException;
}

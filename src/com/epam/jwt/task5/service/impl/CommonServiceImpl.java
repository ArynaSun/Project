package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;

import java.util.List;

public class CommonServiceImpl implements CommonService {
    @Override
    public User findUserById(String userId) throws ServiceException, ValidationException {
        return null;
    }

    @Override
    public List<Course> findCourses(String statusId) throws ServiceException, ValidationException {
        return null;
    }

    @Override
    public Course findCourse(String courseId) throws ServiceException, ValidationException {
        return null;
    }

    @Override
    public List<Task> findTasks(String courseId) throws ServiceException, ValidationException {
        return null;
    }

    @Override
    public List<Solution> findSolutions(String courseId, String studentId) throws ServiceException, ValidationException {
        return null;
    }

    @Override
    public List<Solution> findSolutions(String taskId) throws ServiceException, ValidationException {
        return null;
    }

    @Override
    public List<Request> findRequests() throws ServiceException, ValidationException {
        return null;
    }
}

package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.dao.BaseDao;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.specification.SpecificationFactory;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.service.validator.CommonServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.service.validator.ValidatorHelper;
import com.epam.jwt.task5.service.validator.impl.BaseServiceValidator;

import java.util.ArrayList;
import java.util.List;

public class CommonServiceImpl implements CommonService {
    BaseServiceValidator baseServiceValidator = ValidatorHelper.getBaseServiceValidator();
    CommonServiceValidator commonServiceValidator = ValidatorHelper.getCommonServiceValidator();
    BaseDao<Course, ?> courseDao = DaoHelper.getCourseDao();
    BaseDao<Solution, ?> solutionDao = DaoHelper.getSolutionDao();
    BaseDao<Request, ?> requestDao = DaoHelper.getRequestDao();
    BaseDao<Task, ?> taskDao = DaoHelper.getTaskDao();
    User user = null;

    @Override
    public User findUserById(String userId) throws ServiceException, ValidationException {
        ValidationResult result = commonServiceValidator.validateId(userId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        BaseDao<User, ?> userDao = DaoHelper.getUserDao();
        try {
            user = userDao.readBy(SpecificationFactory.userById(Integer.parseInt(userId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
        return user;
    }

    @Override
    public List<Course> findCourses(String statusId) throws ServiceException, ValidationException {
        List<Course> courseList = null;

        ValidationResult result = commonServiceValidator.validateId(statusId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            courseList = courseDao.read(SpecificationFactory.courseByStatus(Integer.parseInt(statusId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

        return courseList;
    }

    @Override
    public Course findCourse(String courseId) throws ServiceException, ValidationException {
        Course course = null;

        ValidationResult result = commonServiceValidator.validateId(courseId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            course = courseDao.readBy(SpecificationFactory.courseById(Integer.parseInt(courseId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

        return course;
    }

    @Override
    public List<Task> findTasks(String courseId) throws ServiceException, ValidationException {
        List<Task> taskList = null;

        ValidationResult result = commonServiceValidator.validateId((courseId));

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            taskList = taskDao.read(SpecificationFactory.taskByCourseId(Integer.parseInt(courseId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

        return taskList;
    }

    @Override
    public List<Solution> findSolutions(String courseId, String studentId) throws ServiceException, ValidationException {
        List<Solution> solutionList = null;

        ValidationResult result = baseServiceValidator.validateTwoNumbers(courseId, studentId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            solutionList = solutionDao.read(SpecificationFactory.
                    solutionByCourseIdStudentId(Integer.parseInt(courseId), Integer.parseInt(studentId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
        return solutionList;
    }

    @Override
    public List<Solution> findSolutions(String taskId) throws ServiceException, ValidationException {

        List<Solution> solutionList = null;

        ValidationResult result = commonServiceValidator.validateId(taskId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            solutionList = solutionDao.read(SpecificationFactory.solutionByTaskId(Integer.parseInt(taskId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

        return solutionList;
    }

    @Override
    public List<Request> findRequests() throws ServiceException, ValidationException {
        List<Request> requestList = null;

        try {
            requestList = requestDao.read(SpecificationFactory.allRequests());
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
        return requestList;
    }
}

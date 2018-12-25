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

import java.util.List;

public class CommonServiceImpl implements CommonService {
    private BaseServiceValidator baseServiceValidator = ValidatorHelper.getBaseServiceValidator();
    private CommonServiceValidator commonServiceValidator = ValidatorHelper.getCommonServiceValidator();
    private BaseDao<Course, ?> courseDao = DaoHelper.getCourseDao();
    private BaseDao<Solution, ?> solutionDao = DaoHelper.getSolutionDao();
    private BaseDao<Request, ?> requestDao = DaoHelper.getRequestDao();
    private BaseDao<Task, ?> taskDao = DaoHelper.getTaskDao();
    private BaseDao<Review, ?> reviewDao = DaoHelper.getReviewDao();
    private User user = null;

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
    public List<User> findUsersByRoleId(String roleId) throws ServiceException, ValidationException {
        List<User> userList = null;

        ValidationResult result = commonServiceValidator.validateId(roleId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        BaseDao<User, ?> userDao = DaoHelper.getUserDao();
        try {
            userList = userDao.read(SpecificationFactory.usersByRoleId(Integer.parseInt(roleId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
        return userList;
    }

    @Override
    public List<User> findStudentsBy(String courseId) throws ServiceException, ValidationException {
        List<User> userList = null;

        ValidationResult result = commonServiceValidator.validateId(courseId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        BaseDao<User, ?> userDao = DaoHelper.getUserDao();
        try {
            userList = userDao.read(SpecificationFactory.usersBy(Integer.parseInt(courseId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
        return userList;
    }

    @Override
    public List<Course> findCoursesByStatusId(String statusId) throws ServiceException, ValidationException {
        List<Course> courseList = null;

        ValidationResult result = commonServiceValidator.validateId(statusId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            courseList = courseDao.read(SpecificationFactory.coursesByStatus(Integer.parseInt(statusId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

        return courseList;
    }

    @Override
    public List<Course> findCoursesBy(int studentId, int statusId) throws ServiceException, ValidationException {//todo breeed
        List<Course> courseList = null;

        try {
            courseList = courseDao.read(SpecificationFactory.coursesByStudentIdStatusId(studentId, statusId));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

        return courseList;
    }

    @Override
    public Course findCourseByTeacherId(int teacherId) throws ServiceException, ValidationException {
        List<Course> courseList = null;

//        ValidationResult result = commonServiceValidator.validateId(teacherId);
//
//        if (!result.isValid()) {
//            throw new ValidationException(result.getMessage());
//        }

        try {
            courseList = courseDao.read(SpecificationFactory.coursesByTeacherId(teacherId));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

        return courseList != null ? courseList.get(0) : null;
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
            taskList = taskDao.read(SpecificationFactory.tasksByCourseId(Integer.parseInt(courseId)));
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
                    solutionsByCourseIdStudentId(Integer.parseInt(courseId), Integer.parseInt(studentId)));
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
    public List<Request> findRequests(String roleId) throws ServiceException, ValidationException {//todo validator?
        List<Request> requestList = null;

        ValidationResult result = commonServiceValidator.validateId(roleId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            requestList = requestDao.read(SpecificationFactory.requestsByRoleId(Integer.parseInt(roleId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
        return requestList;
    }

    @Override
    public List<Review> findReview(String studentId) throws ServiceException, ValidationException {
        List<Review> reviewList = null;

        ValidationResult result = commonServiceValidator.validateId(studentId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            reviewList = reviewDao.read(SpecificationFactory.reviewsByStudentId(Integer.parseInt(studentId)));
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

        return reviewList;
    }
}

package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.*;
import com.epam.jwt.task5.dao.BaseDao;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;
import com.epam.jwt.task5.dao.specification.SpecificationFactory;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.service.validator.CommonServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessageKey;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.service.validator.ValidatorHelper;
import com.epam.jwt.task5.service.validator.impl.BaseServiceValidator;
import com.epam.jwt.task5.util.PropertyHelper;

import java.util.List;

public class CommonServiceImpl implements CommonService {
    private BaseServiceValidator baseServiceValidator = ValidatorHelper.getBaseServiceValidator();
    private CommonServiceValidator commonServiceValidator = ValidatorHelper.getCommonServiceValidator();
    private BaseDao<Course, ?> courseDao = DaoHelper.getCourseDao();
    private BaseDao<Solution, ?> solutionDao = DaoHelper.getSolutionDao();
    private BaseDao<Request, ?> requestDao = DaoHelper.getRequestDao();
    private BaseDao<Task, ?> taskDao = DaoHelper.getTaskDao();
    private BaseDao<Review, ?> reviewDao = DaoHelper.getReviewDao();
    private BaseDao<User, ?> userDao = DaoHelper.getUserDao();
    private BaseDao<Subject, ?> subjectDao = DaoHelper.getSubjectDao();


    @Override
    public User findUserById(String userId) throws ServiceException, ValidationException {
        ValidationResult result = commonServiceValidator.validateId(userId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }
        User user = null;
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
    public List<Course> findCoursesByTeacherId(int teacherId) throws ServiceException, ValidationException {
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

        return !courseList.isEmpty() ? courseList : null;
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
    public List<Request> findRequests(String roleId) throws ServiceException, ValidationException {
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
    public List<Request> findRequests(String roleId, String requestStatusId) throws ServiceException, ValidationException {
        List<Request> requestList = null;

        ValidationResult result = commonServiceValidator.validateId(roleId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            requestList = requestDao.read(
                    SpecificationFactory.requestsByRoleIdRequestStatusId(
                            Integer.parseInt(roleId), Integer.parseInt(requestStatusId)));
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

    @Override
    public User findUserBy(String email, String password) throws ServiceException, ValidationException {

        try {
            User user = userDao.readBy(SpecificationFactory.userByEmail(email));
            if (user == null){
                throw new ValidationException(PropertyHelper.receiveMessage(ValidationMessageKey.INVALID_EMAIL));
            }
            if (!user.getPassword().equals(password)){
                throw new ValidationException(PropertyHelper.receiveMessage(ValidationMessageKey.INVALID_PASSWORD));
            }
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Subject findSubjectById(String subjectId) throws ServiceException, ValidationException {
        Subject subject = null;

        ValidationResult result = commonServiceValidator.validateId(subjectId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            subject = subjectDao.readBy(SpecificationFactory.subjectById(Integer.parseInt(subjectId)));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        return subject;
    }

    @Override
    public List<Subject> findAllSubjects() throws ServiceException {
        try {
            return subjectDao.read(SpecificationFactory.allSubjects());
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

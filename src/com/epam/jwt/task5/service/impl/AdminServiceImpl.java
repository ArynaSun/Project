package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.BaseDao;
import com.epam.jwt.task5.dao.CourseDao;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.specification.SpecificationFactory;
import com.epam.jwt.task5.service.AdminService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.service.validator.AdminServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessageKey;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.service.validator.ValidatorHelper;

public class AdminServiceImpl implements AdminService {

    private static final int TEACHER_ROLE_ID = 2;
    private AdminServiceValidator adminServiceValidator = ValidatorHelper.getAdminServiceValidator();
    private BaseDao<User, ?> userDao = DaoHelper.getUserDao();
    private CourseDao courseDao = DaoHelper.getCourseDao();

    @Override
    public void registerTeacher(String name, String email, String password) throws ServiceException, ValidationException {

        ValidationResult result = adminServiceValidator.validateUserData(name, email, password);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }
        try {

            User user = userDao.readBy(SpecificationFactory.userByEmail(email));
            if (user != null) {
                throw new ValidationException(ValidationMessageKey.USER_EXISTS_MESSAGE);
            }
            user = new User();

            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            user.setRoleId(TEACHER_ROLE_ID);

            userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addCourse(String name, String description, String teacherId, String subjectId) throws ServiceException, ValidationException {
        ValidationResult result = adminServiceValidator.validateCourse(name, description, teacherId, subjectId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        Course course = new Course();
        course.setName(name);
        course.setDescription(description);
        course.setTeacherId(Integer.parseInt(teacherId));
        course.setSubjectId(Integer.parseInt(subjectId));

        try {
            courseDao.create(course);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addSubject(String name) throws ServiceException, ValidationException {

    }

    @Override
    public void changeCourseTeacher(String courseId, String teacherId) throws ServiceException, ValidationException {

    }

    @Override
    public void changeCourseStatus(String courseId, String statusId) throws ServiceException, ValidationException {
        ValidationResult result = adminServiceValidator.validateTwoNumbers(courseId, statusId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            Course course = courseDao.readBy(SpecificationFactory.courseById(Integer.parseInt(courseId)));
            course.setStatusId(Integer.parseInt(statusId));
            courseDao.update(course);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addStudentToCourse(String studentId, String courseId) throws ServiceException, ValidationException {
        ValidationResult result = adminServiceValidator.validateTwoNumbers(courseId, studentId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        try {
            courseDao.addStudentToCourse(Integer.parseInt(courseId), Integer.parseInt(studentId));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

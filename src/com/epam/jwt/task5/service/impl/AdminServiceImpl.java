package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.CourseDao;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.dao.UserDao;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.service.AdminService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.service.validator.AdminServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessage;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.service.validator.ValidatorHelper;

public class AdminServiceImpl implements AdminService {

    public static final int TEACHER_ROLE_ID = 2;
    private AdminServiceValidator adminServiceValidator = ValidatorHelper.getAdminServiceValidator();
    private UserDao userDao = DaoHelper.getUserDao();
    private CourseDao courseDao = DaoHelper.getCourseDao();

    @Override
    public void registerTeacher(String name, String email, String password) throws ServiceException, ValidationException {

        ValidationResult result = adminServiceValidator.validateUserData(name, email, password);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }
        try {

            User user = userDao.readBy(email);
            if (user != null) {
                throw new ValidationException(ValidationMessage.USER_EXISTS_MESSAGE);
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

        if (!result.isValid()){
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
}

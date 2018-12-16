package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.BaseDao;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.specification.SpecificationFactory;
import com.epam.jwt.task5.service.StudentService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.service.validator.StudentServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessageKey;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.service.validator.ValidatorHelper;

public class StudentServiceImpl implements StudentService {

    private static final int STUDENT_ROLE_ID = 3;

    @Override
    public void registerStudent(String name, String email, String password) throws ServiceException, ValidationException {
        StudentServiceValidator studentServiceValidator = ValidatorHelper.getStudentServiceValidator();

        ValidationResult result = studentServiceValidator.validateUserData(name, email, password);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }
        try {

            BaseDao<User, ?> userDao = DaoHelper.getUserDao();
            User user = userDao.readBy(SpecificationFactory.userByEmail(email));
            if (user != null) {
                throw new ValidationException(ValidationMessageKey.USER_EXISTS_MESSAGE);
            }
            user = new User();

            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRoleId(STUDENT_ROLE_ID);


            userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}

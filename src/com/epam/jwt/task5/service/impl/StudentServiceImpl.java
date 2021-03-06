package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.*;
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
import com.epam.jwt.task5.service.validator.impl.BaseServiceValidator;
import com.epam.jwt.task5.util.PropertyHelper;

public class StudentServiceImpl implements StudentService {

    private StudentServiceValidator studentServiceValidator = ValidatorHelper.getStudentServiceValidator();
    private BaseServiceValidator baseServiceValidator = ValidatorHelper.getBaseServiceValidator();

    @Override
    public void registerStudent(String name, String email, String password) throws ServiceException, ValidationException {

        ValidationResult result = studentServiceValidator.validateUserData(name, email, password);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }
        try {

            BaseDao<User, ?> userDao = DaoHelper.getUserDao();
            User user = userDao.readBy(SpecificationFactory.userByEmail(email));
            if (user != null) {
                throw new ValidationException(PropertyHelper.receiveMessage(ValidationMessageKey.USER_EXISTS_MESSAGE));
            }
            user = new User();

            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRoleId(Role.STUDENT.getId());


            userDao.create(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void createSolution(String studentId, String taskId, String mark, String answer, String attachments)
            throws ServiceException, ValidationException {
        ValidationResult result = studentServiceValidator.validateSolutionData(studentId, taskId,
                mark, answer, attachments);

        if (!result.isValid()){
            throw new ValidationException(result.getMessage());
        }

        BaseDao<Solution, ?> solutionDao = DaoHelper.getSolutionDao();
        Solution solution = new Solution();
        solution.setStudentId(Integer.parseInt(studentId));
        solution.setTaskId(Integer.parseInt(taskId));
        solution.setAnswer(answer);
        solution.setAttachments(attachments);

        try {
            solutionDao.create(solution);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void createRequest(String name, String userId, String courseId) throws ServiceException, ValidationException{
        ValidationResult result = baseServiceValidator.validateRequestData(name, userId, courseId);

        if (!result.isValid()){
            throw new ValidationException(result.getMessage());
        }
        try {

        BaseDao<Request, ?> requestDao = DaoHelper.getRequestDao();
        Request request = requestDao.readBy(
                SpecificationFactory.requestsBy(Integer.valueOf(userId), Integer.valueOf(courseId)));
        if (request == null) {
            request = new Request();
            request.setUserId(Integer.parseInt(userId));
            request.setName(name);
            request.setStatusId(RequestStatus.SENT.getId());
            request.setCourseId(Integer.parseInt(courseId));
        } else {
            throw new ValidationException(PropertyHelper.receiveMessage(ValidationMessageKey.REQUEST_EXISTS));
        }
            requestDao.create(request);
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
    }
}

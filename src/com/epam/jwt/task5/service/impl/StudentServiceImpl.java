package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.bean.Solution;
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
import com.epam.jwt.task5.service.validator.impl.BaseServiceValidator;

public class StudentServiceImpl implements StudentService {

    private static final int STUDENT_ROLE_ID = 3;
    private static final int SENT_STATUS_ID = 3;
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
        solution.setMark(Integer.parseInt(mark));
        solution.setAnswer(answer);
        solution.setAttachments(attachments);//todo should be null

        try {
            solutionDao.create(solution);
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
    }

    @Override
    public void createRequest(String name, String userId) throws ServiceException, ValidationException{
        ValidationResult result = baseServiceValidator.validateRequestData(name, userId);

        if (!result.isValid()){
            throw new ValidationException(result.getMessage());
        }

        BaseDao<Request, ?> requestDao = DaoHelper.getRequestDao();
        Request request = new Request();
        request.setUserId(Integer.parseInt(userId));
        request.setName(name);
        request.setStatusId(SENT_STATUS_ID);

        try {
            requestDao.create(request);
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }
    }
}

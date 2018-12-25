package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.bean.Review;
import com.epam.jwt.task5.bean.Solution;
import com.epam.jwt.task5.bean.Task;
import com.epam.jwt.task5.dao.BaseDao;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.specification.SpecificationFactory;
import com.epam.jwt.task5.service.TeacherService;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import com.epam.jwt.task5.service.validator.TeacherServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.service.validator.ValidatorHelper;
import com.epam.jwt.task5.service.validator.impl.BaseServiceValidator;

public class TeacherServiceImpl implements TeacherService {
    private static final int REQUEST_STATUS_ID = 3;
    private TeacherServiceValidator teacherServiceValidator = ValidatorHelper.getTeacherServiceValidator();
    private BaseServiceValidator baseServiceValidator = ValidatorHelper.getBaseServiceValidator();

    @Override
    public void createTask(String courseId, String name, String attachments, String assignmentDate,
                           String deadline) throws ServiceException, ValidationException {
        ValidationResult result = teacherServiceValidator.validateTaskData(courseId, name,
                attachments, assignmentDate, deadline);
        if (!result.isValid()){
            throw new ValidationException(result.getMessage());//todo mes
        }

        BaseDao<Task, ?> taskDao = DaoHelper.getTaskDao();

        Task task = new Task();
        task.setCourseId(Integer.parseInt(courseId));
        task.setName(name);
        task.setAttachments(attachments);
        task.setAssignmentDate(assignmentDate);
        task.setDeadline(deadline);

        try {
            taskDao.create(task);
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

    }

    @Override
    public void createReview(String studentId, String courseId, String mark, String description)
            throws ServiceException, ValidationException {
        ValidationResult result = teacherServiceValidator.validateReviewData(studentId, courseId, mark, description);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }

        BaseDao<Review, ?> reviewDao = DaoHelper.getReviewDao();

        Review review = new Review();
        review.setStudentId(Integer.parseInt(studentId));
        review.setCourseId(Integer.parseInt(courseId));
        review.setMark(Integer.parseInt(mark));
        review.setDescription(description);

        try {
            reviewDao.create(review);
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

    }

    @Override
    public void checkSolution(String solutionId, String mark) throws ServiceException, ValidationException {
        ValidationResult result = teacherServiceValidator.validateSolution(solutionId, mark);

        if (!result.isValid()){
            throw new ValidationException(result.getMessage());//todo mes
        }

        BaseDao<Solution, ?> solutionDao = DaoHelper.getSolutionDao();
        try {
            Solution solution = solutionDao.readBy(SpecificationFactory.solutionById(Integer.parseInt(solutionId)));
            solution.setMark(Integer.parseInt(mark));
            solutionDao.update(solution);
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }


    }

    @Override
    public void createRequest(String name, String userId, String courseId) throws ServiceException, ValidationException {
        ValidationResult result = baseServiceValidator.validateRequestData(name, userId, courseId);

        if (!result.isValid()) {
            throw new ValidationException(result.getMessage());
        }
        Request request = new Request();

        BaseDao<Request, ?> requestDao = DaoHelper.getRequestDao();

        request.setUserId(Integer.parseInt(userId));
        request.setName(name);
        request.setStatusId(REQUEST_STATUS_ID);
        request.setCourseId(Integer.parseInt(courseId));

        try {
            requestDao.create(request);
        } catch (DaoException e) {
            throw new ServiceException(e);//todo mes
        }

    }
}

package com.epam.jwt.task5.service;

import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;

public interface TeacherService extends UserService {
    void createTask(String courseId, String name, String attachments,
                    String assignmentDate, String deadline)
            throws ServiceException, ValidationException;
    void createReview(String studentId, String courseId, String mark, String description)
            throws ServiceException, ValidationException;
    void checkSolution(String solutionId, String mark) throws ServiceException, ValidationException;
}

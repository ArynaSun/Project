package com.epam.jwt.task5.service.validator;

public interface StudentServiceValidator extends UserValidator  {
    ValidationResult validateSolutionData(String studentId, String taskId, String mark,
                                          String answer, String attachments);
}

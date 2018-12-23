package com.epam.jwt.task5.service.validator;

public interface TeacherServiceValidator {
    ValidationResult validateTaskData(String courseId, String name, String attachments, String assignmentDate,
                                      String deadline);

    ValidationResult validateReviewData(String studentId, String courseId,
                                        String mark, String description);

    ValidationResult validateSolution(String solutionId, String mark);
}

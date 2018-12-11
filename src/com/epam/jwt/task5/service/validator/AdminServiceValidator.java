package com.epam.jwt.task5.service.validator;

public interface AdminServiceValidator extends UserValidator {
    ValidationResult validateCourse(String name, String description, String teacherId, String subjectId);

    ValidationResult validateTwoNumbers(String firstNumber, String secondNumber);
}

package com.epam.jwt.task5.service.validator;

public interface UserValidator {
    ValidationResult validateUserData(String name, String email, String password);
}

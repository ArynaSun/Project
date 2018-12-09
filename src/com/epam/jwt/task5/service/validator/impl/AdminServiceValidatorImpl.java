package com.epam.jwt.task5.service.validator.impl;

import com.epam.jwt.task5.service.validator.AdminServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessage;
import com.epam.jwt.task5.service.validator.ValidationResult;

public class AdminServiceValidatorImpl extends BaseServiceValidator implements AdminServiceValidator {

    public static final int MAX_DESCRIPTION_LENGTH = 1000;

    @Override
    public ValidationResult validateCourse(String name, String description, String teacherId, String subjectId) {
        ValidationResult result = new ValidationResult();

        if (!validateName(name)) {
            result.setValid(false);
            result.addMessage(ValidationMessage.NOT_VALID_NAME_COURSE_MESSAGE);
        }

        if (!validateDescription(description)) {
            result.setValid(false);
            result.addMessage(ValidationMessage.NOT_VALID_DESCRIPTION_COURSE_MESSAGE);
        }

        if (!validateNumber(teacherId) || !validateNumber(subjectId)) {
            result.setValid(false);
            result.addMessage(ValidationMessage.HACKER_HELLO_MESSAGE);
        }

        return result;
    }


    private boolean validateDescription(String description) {
        return description != null && !description.isEmpty() && description.length() < MAX_DESCRIPTION_LENGTH;
    }
}

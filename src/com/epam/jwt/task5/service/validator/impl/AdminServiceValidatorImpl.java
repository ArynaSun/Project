package com.epam.jwt.task5.service.validator.impl;

import com.epam.jwt.task5.service.validator.AdminServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessageKey;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.util.PropertyHelper;

public class AdminServiceValidatorImpl extends BaseServiceValidator implements AdminServiceValidator {

    @Override
    public ValidationResult validateCourse(String name, String description, String teacherId, String subjectId) {
        ValidationResult result = new ValidationResult();

        if (!validateName(name)) {
            result.setValid(false);
            result.addMessage(PropertyHelper.receiveMessage(ValidationMessageKey.NOT_VALID_NAME_MESSAGE));
        }

        if (!validateDescription(description)) {
            result.setValid(false);
            result.addMessage(PropertyHelper.receiveMessage(ValidationMessageKey.NOT_VALID_DESCRIPTION_MESSAGE));
        }

        if (!validateNumber(teacherId) || !validateNumber(subjectId)) {
            result.setValid(false);
            result.addMessage(PropertyHelper.receiveMessage(ValidationMessageKey.HACKER_HELLO_MESSAGE));
        }

        return result;
    }
}

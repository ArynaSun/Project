package com.epam.jwt.task5.service.validator.impl;

import com.epam.jwt.task5.service.validator.CommonServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessageKey;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.util.PropertyHelper;

public class CommonServiceValidatorImpl extends BaseServiceValidator implements CommonServiceValidator {
    @Override
    public ValidationResult validateId(String id) {
        ValidationResult result = new ValidationResult();
        if (!validateNumber(id)){
            result.setValid(false);
            result.addMessage(PropertyHelper.receiveMessage(ValidationMessageKey.HACKER_HELLO_MESSAGE));
        }
        return result;
    }
}

package com.epam.jwt.task5.service.validator.impl;

import com.epam.jwt.task5.service.validator.UserValidator;
import com.epam.jwt.task5.service.validator.ValidationMessage;
import com.epam.jwt.task5.service.validator.ValidationResult;

public class BaseServiceValidator implements UserValidator {


    public static final int MAX_NAME_LENGTH = 20;
    public static final String NAME_REGEX = "[a-zA-Zа-яА-Я]+";
    public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
            "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\" +
            "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\" +
            "[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
            "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final int MIN_PASSWORD_LENGTH = 5;
    public static final int MAX_PASSWORD_LENGTH = 21;

    @Override
    public ValidationResult validateUserData(String name, String email, String password) {
        ValidationResult validationResult = new ValidationResult();

        if (!validateName(name)) {
            validationResult.setValid(false);
            validationResult.addMessage(ValidationMessage.NOT_VALID_NAME_MESSAGE);
        }
        if (!validateEmail(email)) {
            validationResult.setValid(false);
            validationResult.addMessage(ValidationMessage.NOT_VALID_EMAIL_MESSAGE);
        }
        if (!validatePassword(password)) {
            validationResult.setValid(false);
            validationResult.addMessage(ValidationMessage.NOT_VALID_PASSWORD_MESSAGE);
        }

        return validationResult;
    }

    protected boolean validatePassword(String password) {
        return password != null && !password.isEmpty() &&
                password.length() > MIN_PASSWORD_LENGTH && password.length() < MAX_PASSWORD_LENGTH;
    }

    protected boolean validateEmail(String email) {
        return email != null && !email.isEmpty() && email.matches(EMAIL_REGEX);
    }

    protected boolean validateName(String name) {
        return (name != null && !name.isEmpty() && name.length() < MAX_NAME_LENGTH
                && name.matches(NAME_REGEX));
    }
    protected boolean validateNumber(String number) {
        try{
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}

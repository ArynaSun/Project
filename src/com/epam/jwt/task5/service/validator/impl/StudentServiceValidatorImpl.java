package com.epam.jwt.task5.service.validator.impl;

import com.epam.jwt.task5.service.validator.StudentServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessageKey;
import com.epam.jwt.task5.service.validator.ValidationResult;
import com.epam.jwt.task5.util.PropertyHelper;

public class StudentServiceValidatorImpl extends BaseServiceValidator implements StudentServiceValidator {

    private static final int MIN_LENGTH_ANSWER = 2;
    private static final int MAX_LENGTH_ANSWER = 1000;

    @Override
    public ValidationResult validateSolutionData(String studentId, String taskId, String mark,
                                                 String answer, String attachments) {
        ValidationResult result = new ValidationResult();

        if (!validateNumber(studentId)) {
            result.setValid(false);
            result.addMessage(PropertyHelper.receiveMessage(ValidationMessageKey.HACKER_HELLO_MESSAGE));
        }

        if (!validateNumber(taskId)) {
            result.setValid(false);
            result.addMessage(PropertyHelper.receiveMessage(ValidationMessageKey.HACKER_HELLO_MESSAGE));
        }

        if (!validateAnswer(answer)) {
            result.setValid(false);
            result.addMessage(PropertyHelper.receiveMessage(ValidationMessageKey.INVALID_ANSWER_MESSAGE));
        }

        return result;
    }

    private boolean validateAnswer(String answer) {
        return answer != null && !answer.isEmpty() && answer.length() >= MIN_LENGTH_ANSWER &&
                answer.length() <= MAX_LENGTH_ANSWER;
    }


}

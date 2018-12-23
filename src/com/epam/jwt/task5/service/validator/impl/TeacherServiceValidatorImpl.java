package com.epam.jwt.task5.service.validator.impl;

import com.epam.jwt.task5.service.validator.TeacherServiceValidator;
import com.epam.jwt.task5.service.validator.ValidationMessageKey;
import com.epam.jwt.task5.service.validator.ValidationResult;

public class TeacherServiceValidatorImpl extends BaseServiceValidator implements TeacherServiceValidator {

    @Override
    public ValidationResult validateTaskData(String courseId, String name, String attachments, String assignmentDate,
                                             String deadline) {
        ValidationResult result = new ValidationResult();

        if (!validateNumber(courseId)){
            result.setValid(false);
            result.addMessage(ValidationMessageKey.HACKER_HELLO_MESSAGE);
        }
        if (!validateName(name)){
            result.setValid(false);
            result.addMessage(ValidationMessageKey.NOT_VALID_NAME_MESSAGE);
        }

        if (!validateDate(assignmentDate) || !validateDate(deadline)){
            result.setValid(false);
            result.addMessage(ValidationMessageKey.INVALID_DATE_FORMATE_MESSAGE);
        }

        return result;
    }

    @Override
    public ValidationResult validateReviewData(String studentId, String courseId, String mark, String description) {
        ValidationResult result = new ValidationResult();

        if (!validateNumber(studentId) || !validateNumber(courseId)){//todo || or &&
            result.setValid(false);
            result.addMessage(ValidationMessageKey.HACKER_HELLO_MESSAGE);
        }

        if (!validateMark(mark)){
            result.setValid(false);
            result.addMessage(ValidationMessageKey.INVALID_MARK_MESSAGE);
        }

        if (!validateDescription(description)){
            result.setValid(false);
            result.addMessage(ValidationMessageKey.NOT_VALID_DESCRIPTION_MESSAGE);//TODO
        }

        return result;
    }

    @Override
    public ValidationResult validateSolution(String solutionId, String mark) {
        ValidationResult result = new ValidationResult();

        if (!validateNumber(solutionId)){
            result.setValid(false);
            result.addMessage(ValidationMessageKey.HACKER_HELLO_MESSAGE);
        }

        if (!validateMark(mark)){
            result.setValid(false);
            result.addMessage(ValidationMessageKey.INVALID_MARK_MESSAGE);
        }

        return result;
    }

}

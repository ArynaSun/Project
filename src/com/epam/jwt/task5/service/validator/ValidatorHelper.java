package com.epam.jwt.task5.service.validator;

import com.epam.jwt.task5.service.validator.impl.AdminServiceValidatorImpl;
import com.epam.jwt.task5.service.validator.impl.StudentServiceValidatorImpl;

public class ValidatorHelper {
    private final static AdminServiceValidator adminServiceValidator = new AdminServiceValidatorImpl();
    private final static StudentServiceValidator studentServiceValidator =new StudentServiceValidatorImpl();

    public static AdminServiceValidator getAdminServiceValidator() {
        return adminServiceValidator;
    }

    public static StudentServiceValidator getStudentServiceValidator() {
        return studentServiceValidator;
    }
}

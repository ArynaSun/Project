package com.epam.jwt.task5.service.validator;

import com.epam.jwt.task5.service.validator.impl.*;

public class ValidatorHelper {
    private static final BaseServiceValidator baseServiceValidator = new BaseServiceValidator();
    private static final AdminServiceValidator adminServiceValidator = new AdminServiceValidatorImpl();
    private static final StudentServiceValidator studentServiceValidator =new StudentServiceValidatorImpl();
    private static final TeacherServiceValidator teacherServiceValidator = new TeacherServiceValidatorImpl();
    private static final CommonServiceValidator commonServiceValidator = new CommonServiceValidatorImpl();

    public static BaseServiceValidator getBaseServiceValidator() {
        return baseServiceValidator;
    }

    public static AdminServiceValidator getAdminServiceValidator() {
        return adminServiceValidator;
    }

    public static StudentServiceValidator getStudentServiceValidator() {
        return studentServiceValidator;
    }

    public static TeacherServiceValidator getTeacherServiceValidator() {
        return teacherServiceValidator;
    }

    public static CommonServiceValidator getCommonServiceValidator() {
        return commonServiceValidator;
    }
}

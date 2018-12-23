package com.epam.jwt.task5.service.validator;

import com.epam.jwt.task5.service.validator.impl.AdminServiceValidatorImpl;
import com.epam.jwt.task5.service.validator.impl.BaseServiceValidator;
import com.epam.jwt.task5.service.validator.impl.StudentServiceValidatorImpl;
import com.epam.jwt.task5.service.validator.impl.TeacherServiceValidatorImpl;

public class ValidatorHelper {
    private static final BaseServiceValidator baseServiceValidator = new BaseServiceValidator();
    private static final AdminServiceValidator adminServiceValidator = new AdminServiceValidatorImpl();
    private static final StudentServiceValidator studentServiceValidator =new StudentServiceValidatorImpl();
    private static final TeacherServiceValidator teacherServiceValidator = new TeacherServiceValidatorImpl();

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
}

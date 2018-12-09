package com.epam.jwt.task5.service;

import com.epam.jwt.task5.service.impl.AdminServiceImpl;
import com.epam.jwt.task5.service.impl.StudentServiceImpl;

public class ServiceHelper {
    private static AdminService adminService = new AdminServiceImpl();
    private static StudentService studentService = new StudentServiceImpl();

    public static AdminService getAdminService() {
        return adminService;
    }

    public static StudentService getStudentService() {
        return studentService;
    }
}

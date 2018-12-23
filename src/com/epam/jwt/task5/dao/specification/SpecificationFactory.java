package com.epam.jwt.task5.dao.specification;

import com.epam.jwt.task5.dao.specification.impl.*;

public class SpecificationFactory {
    public static DaoSpecification userById(int id){
        return new UserByIdSpecification(id);
    }

    public static DaoSpecification userByEmail(String email) {
        return new UserByEmailSpecification(email);
    }

    public static DaoSpecification userByEmailPassword(String email, String password) {
        return new UserByEmailPasswordSpecification(email, password);
    }

    public static DaoSpecification courseById(int id) {
        return new CourseByIdSpecification(id);
    }

    public static DaoSpecification courseByStatus(int statusId){
        return new CoursesByStatusSpecification(statusId);
    }

    public static DaoSpecification solutionById(int id){
        return new SolutionByIdSpecification(id);
    }

    public static DaoSpecification solutionByTaskId(int taskId){
        return new SolutionByTaskIdSpecification(taskId);
    }

    public static DaoSpecification solutionByCourseIdStudentId(int courseId, int studentId){
        return new SolutionByCourseIdStudentIdSpecification(courseId, studentId);
    }

    public static DaoSpecification taskByCourseId(int courseId){
        return new TasksByCourseIdSpecification(courseId);
    }

    public static DaoSpecification requestById(int id){
        return new RequestByIdSpecification(id);
    }

    public static DaoSpecification allRequests(){
        return new AllRequestsSpecification();
    }
}


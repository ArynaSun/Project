package com.epam.jwt.task5.dao.specification;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.bean.Subject;
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

    public static DaoSpecification usersByRoleId(int roleId){
        return new UsersByRoleIdSpecification(roleId);
    }

    public static DaoSpecification usersBy(int courseId){return new UsersByCourseIdSpecification(courseId);}

    public static DaoSpecification courseById(int id) {
        return new CourseByIdSpecification(id);
    }

    public static DaoSpecification coursesByStatus(int statusId){
        return new CoursesByStatusSpecification(statusId);
    }

    public static DaoSpecification coursesByStudentIdStatusId(int studentId, int statusId){
        return new CoursesByStudentIdStatusIdSpecification(studentId, statusId);
    }

    public static DaoSpecification coursesByTeacherId(int teacherId){return new CoursesByTeacherIdSpecification(teacherId);}

    public static DaoSpecification solutionById(int id){
        return new SolutionByIdSpecification(id);
    }

    public static DaoSpecification solutionByTaskId(int taskId){
        return new SolutionsByTaskIdSpecification(taskId);
    }

    public static DaoSpecification solutionsByCourseIdStudentId(int courseId, int studentId){
        return new SolutionByCourseIdStudentIdSpecification(courseId, studentId);
    }

    public static DaoSpecification subjectById(int id){
        return new SubjectByIdSpecification(id);
    }

    public static DaoSpecification tasksByCourseId(int courseId){
        return new TasksByCourseIdSpecification(courseId);
    }

    public static DaoSpecification requestsById(int id){
        return new RequestByIdSpecification(id);
    }

    public static DaoSpecification requestsByRoleId(int roleId){return new RequestsByRoleIdSpecification(roleId);}

    public static DaoSpecification allRequests(){
        return new AllRequestsSpecification();
    }

    public static DaoSpecification reviewsByStudentId(int studentId){return new ReviewsByStudentIdSpecification(studentId);}

    public static DaoSpecification requestsBy(int userId, int courseId) {
        return new  RequestByUserIdAndCourseIdSpecification(userId, courseId);
    }

    public static DaoSpecification allSubjects() {
        return new AllSubjectsSpecification();
    }

    public static DaoSpecification requestsByRoleIdRequestStatusId(int roleId, int requestStatusId) {
        return new RequestByIdRequestStatusIdSpecification(roleId, requestStatusId);
    }
}


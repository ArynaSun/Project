package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class CourseStudentRelation implements Serializable {
    private int courseId;
    private int studentId;

    public CourseStudentRelation() {
    }

    public CourseStudentRelation(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}

package com.epam.jwt.task5.dto;

import com.epam.jwt.task5.bean.Course;

public class CourseDTO {
    private Course course;
    private String teacherName;
    private String subjectName;

    public CourseDTO() {
    }

    public CourseDTO(Course course, String teacherName, String subjectName) {
        this.course = course;
        this.teacherName = teacherName;
        this.subjectName = subjectName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

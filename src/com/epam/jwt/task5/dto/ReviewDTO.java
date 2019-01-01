package com.epam.jwt.task5.dto;

import com.epam.jwt.task5.bean.Review;

public class ReviewDTO {
    private Review review;
    private String studentName;
    private String courseName;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review, String studentName, String courseName) {
        this.review = review;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

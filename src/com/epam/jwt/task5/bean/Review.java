package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Review implements Serializable {
    private int id;
    private int studentId;
    private int courseId;
    private int mark;
    private String description;

    public Review() {
    }

    public Review(int id, int studentId, int courseId, int mark, String description) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.mark = mark;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Review review = (Review) obj;

        if (id != review.id) {
            return false;
        }
        if (studentId != review.studentId) {
            return false;
        }
        if (courseId != review.courseId) {
            return false;
        }
        if (mark != review.mark) {
            return false;
        }
        if (description == null) {
            return (description == review.description);
        } else {
            if (!description.equals(review.description)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((id * 31) + (studentId) * 13 + (courseId * 11) + (mark * 17)
                + ((null == description) ? 0 : (description.hashCode() * 13)));
    }

    @Override
    public String toString() {
        return getClass().getName() + "id: " + id + ", studentId: " + studentId +
                ", courseId: " + courseId + ", mark: " + mark + ", description: " + description;
    }
}

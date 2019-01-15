package com.epam.jwt.task5.dto;

import com.epam.jwt.task5.bean.Solution;
import com.epam.jwt.task5.bean.User;

import java.io.Serializable;
import java.util.List;

public class SolutionDTO implements Serializable {
    private Solution solution;
    private String studentName;

    public SolutionDTO() {
    }

    public SolutionDTO(Solution solution, String studentName) {
        this.solution = solution;
        this.studentName = studentName;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}

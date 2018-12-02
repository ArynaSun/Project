package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Task implements Serializable{
    private int id;
    private int courseId;
    private int studentId;
    private int solutionId;
    private double mark;
    private boolean isDone;
    private boolean isAccepted;
    private String name;
    private String attachments;

}

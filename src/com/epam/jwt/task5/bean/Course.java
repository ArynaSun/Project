package com.epam.jwt.task5.bean;

import java.io.Serializable;
import java.util.List;

public class Course implements Serializable {
    private int id;
    private int teacherId;
    private int subjectId;
    private String name;
    private List<Integer> studentIds;
}

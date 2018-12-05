package com.epam.jwt.task5.bean;

import java.io.Serializable;

public enum SolutionStatus implements Serializable{//TODO&&&??
    IS_DONE(1,"Готово"), IS_ACCEPTED(2, "Одобрено"), IS_EXPIRED(3, "Просрочено"), IS_REJECTED(4,"Отклонено");
    private final int id;
    private final String name;

    SolutionStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

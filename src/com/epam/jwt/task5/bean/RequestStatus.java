package com.epam.jwt.task5.bean;

import java.io.Serializable;

public enum RequestStatus implements Serializable{

    IS_ACCEPTED(1, "Одобрена"), IS_REJECTED(2, "Отклонена"), SENT(3, "Отправлена") ;

    private final int id;
    private final String name;

    RequestStatus(int id, String name) {
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

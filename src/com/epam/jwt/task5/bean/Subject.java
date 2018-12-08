package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class Subject implements Serializable {
    private String name;
    private int id;

    public Subject() {
    }

    public Subject(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        Subject subject = (Subject)obj;

        if(null == name){
            return (name == subject.name);
        }else {
            if(!name.equals(subject.name)){
                return false;
            }
        }
        if (id!=subject.id){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((name == null) ? 0 : (name.hashCode()) * 11) + (id * 31);
    }

    @Override
    public String toString(){
        return getClass().getName() + "name: " + name + ", id: " + id;
    }
}

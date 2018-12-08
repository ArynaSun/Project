package com.epam.jwt.task5.bean;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private int roleId;
    private String name;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, int roleId, String name, String email, String password) {
        this.id = id;
        this.roleId = roleId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

        User user = (User) obj;
        if (id != user.id) {
            return false;
        }
        if (roleId != user.roleId) {
            return false;
        }
        if (null == name) {
            return (name == user.name);
        } else {
            if (!name.equals(user.name)) {
                return false;
            }
        }
        if (null == email) {
            return (email == user.email);
        } else {
            if (!email.equals(user.email)) {
                return false;
            }
        }
        if (null == password) {
            return (password == user.password);
        } else {
            if (!password.equals(user.password)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return ((id * 31) + (roleId * 11) + ((name == null) ? 0 : (name.hashCode() * 13))
                + ((email == null) ? 0 : (email.hashCode() * 17))
                + ((password == null) ? 0 : (password.hashCode() * 31)));
    }

    @Override
    public String toString() {
        return getClass().getName() + "id: " + id + ", roleId: " + roleId +  ", name: "
                + name + ", email: " + email + ", password: " + password;
    }
}

package com.epam.jwt.task5.dao.impl;

public interface SqlQuery {

    String SELECT_FROM_USER_WHERE_EMAIL_AND_PASSWORD = "SELECT * FROM user WHERE email = ? AND password = ?";
    String INSERT_INTO_USER_EMAIL_PASSWORD_NAME_ROLE_ID_VALUES = "INSERT INTO user (email, password, name, role_id) VALUES (?, ?, ?, ?)";
}

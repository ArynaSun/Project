package com.epam.jwt.task5.dao.impl;

public interface SqlQuery {

    String SELECT_FROM_USER_WHERE_PASSORD_AND_EMAIL = "SELECT * FROM user WHERE password = ? AND email = ?";
    String INSERT_INTO_USER_EMAIL_PASSORD_NAME_ROLE_ID_VALUES = "INSERT INTO user (email, password, name, role_id) VALUES (?, ?, ?, ?)";
}

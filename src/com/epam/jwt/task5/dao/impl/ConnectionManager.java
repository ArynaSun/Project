package com.epam.jwt.task5.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/coursedb?" +
            "useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC&" +
            "characterEncoding=utf8";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() throws ConnectionException {
        try {
            return DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            throw new ConnectionException(e);
        }
    }
}

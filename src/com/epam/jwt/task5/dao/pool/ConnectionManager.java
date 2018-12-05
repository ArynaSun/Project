package com.epam.jwt.task5.dao.pool;

import com.epam.jwt.task5.dao.exception.ConnectionException;
import com.epam.jwt.task5.dao.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Logger logger = LogManager.getLogger(ConnectionPool.class);//TODO maybe i will use it

    private static final String URL = "jdbc:mysql://localhost:3306/coursedb?" +
            "useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC&" +
            "characterEncoding=utf8";
    private static final String user = "root";
    private static final String password = "root";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ConnectionPool pool = null;

    static {
        try {
            pool = new ConnectionPool(3, URL, user, password);
        } catch (ConnectionException | ConnectionPoolException e) {
            logger.info(e.getMessage());
        }
    }

    static Connection createConnection() throws ConnectionException {
        try {
            return DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            throw new ConnectionException(e);
        }
    }

    public static ConnectionPool getPool(){
        return pool;
    }
}

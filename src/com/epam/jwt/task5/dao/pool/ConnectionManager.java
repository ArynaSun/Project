package com.epam.jwt.task5.dao.pool;

import com.epam.jwt.task5.dao.exception.ConnectionException;
import com.epam.jwt.task5.dao.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Logger logger = LogManager.getLogger(ConnectionPool.class);

    private static final String URL = "jdbc:mysql://localhost:3306/coursedb?" +
            "useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC&" +
            "characterEncoding=utf8";
    private static final String user = "root";
    private static final String password = "root";

    public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ConnectionPool pool = null;

    public static final int POOL_SIZE = 3;

    static {
        try {
            pool = new ConnectionPool(POOL_SIZE, URL, user, password);
        } catch (ConnectionException | ConnectionPoolException e) {
            logger.error("Ошибка соеднинения", e);
        }
    }

    static Connection createConnection() throws ConnectionException {
        try {
            return DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            throw new ConnectionException("Ошибка соеднинения с базой", e);// нужно ли в константу
        }
    }

    public static ConnectionPool getPool(){
        return pool;
    }
}

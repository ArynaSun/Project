package com.epam.jwt.task5.dao.pool;

import com.epam.jwt.task5.dao.exception.ConnectionException;
import com.epam.jwt.task5.dao.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {



    private final String url;
    private final String user;
    private final String password;

    private BlockingQueue<Connection> freeConnections;
    private BlockingQueue<Connection> workingConnections;

    public ConnectionPool(int poolSize, String url, String user, String password) throws ConnectionException, ConnectionPoolException {
        this.url = url;
        this.user = user;
        this.password = password;

        freeConnections = new ArrayBlockingQueue<Connection>(poolSize);
        workingConnections = new ArrayBlockingQueue<Connection>(poolSize);

        for (int i = 0; i<poolSize;i++){
            try {
                freeConnections.put(ConnectionManager.createConnection());
            } catch (InterruptedException e) {
                throw new ConnectionPoolException(e);
            }
        }
    }

    public Connection takeConnection() throws ConnectionPoolException {
        Connection connection = null;
        try {
            connection = freeConnections.take();
            workingConnections.put(connection);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);
        }

        return connection;
    }

    public void releaseConnection(Connection connection) throws ConnectionPoolException {
        workingConnections.remove(connection);
        try {
            freeConnections.put(connection);
        } catch (InterruptedException e) {//TODO or just log?
            throw new ConnectionPoolException(e);
        }
    }

    private void clearConnectionQueue() throws ConnectionException {//TODO private/public
        Connection connection = null;
        while ( (connection = freeConnections.poll()) !=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new ConnectionException(e);
            }
        }
        while ((connection = workingConnections.poll()) != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new ConnectionException(e);
            }
        }
    }
}

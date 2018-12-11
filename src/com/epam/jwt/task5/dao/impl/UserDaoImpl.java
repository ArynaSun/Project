package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.ConnectionPoolException;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.UserDao;
import com.epam.jwt.task5.dao.pool.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public void create(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_USER_EMAIL_PASSWORD_NAME_ROLE_ID_VALUES);
            preparedStatement.setString(PreparedStatementIndexes.INSERT_USER_EMAIL_INDEX, user.getEmail());
            preparedStatement.setString(PreparedStatementIndexes.INSERT_USER_PASSWORD_INDEX, user.getPassword());
            preparedStatement.setString(PreparedStatementIndexes.INSERT_USER_NAME_INDEX, user.getName());
            preparedStatement.setInt(PreparedStatementIndexes.INSERT_USER_ROLE_ID_INDEX, user.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.info("Unable to close preparedStatement");
                }
            }
            if (connection != null) {
                try {
                    ConnectionManager.getPool().releaseConnection(connection);
                } catch (ConnectionPoolException e) {
                    logger.info("Unable to close connection");
                }
            }
        }
    }

    @Override
    public User readBy(int id) {
        return null;
    }

    @Override
    public List<User> readAll() throws DaoException {
        return null;
    }

    @Override
    public User readBy(String email, String password) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User user = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.SELECT_FROM_USER_WHERE_EMAIL_AND_PASSWORD);

            preparedStatement.setString(PreparedStatementIndexes.SELECT_USER_EMAIL_INDEX, email);
            preparedStatement.setString(PreparedStatementIndexes.SELECT_USER_PASSWORD_INDEX, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(ColumnInfo.USER_ID));
                user.setRoleId(resultSet.getInt(ColumnInfo.USER_ROLE_ID));
                user.setName(resultSet.getString(ColumnInfo.USER_NAME));
                user.setEmail(email);
                user.setPassword(password);
            }

        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.info("Unable to close resultSet");//TODO ??
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.info("Unable to close preparedStatement");
                }
            }
            if (connection != null) {
                try {
                    ConnectionManager.getPool().releaseConnection(connection);
                } catch (ConnectionPoolException e) {
                    logger.info("Unable to close connection");
                }
            }
        }
        return user;
    }

    @Override
    public User readBy(String email) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User user = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(SqlQuery.SELECT_FROM_USER_WHERE_EMAIL);
            preparedStatement.setString(PreparedStatementIndexes.SELECT_USER_EMAIL_INDEX,email);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setName(resultSet.getString(ColumnInfo.USER_NAME));
                user.setId(resultSet.getInt(ColumnInfo.USER_ID));
                user.setRoleId(resultSet.getInt(ColumnInfo.USER_ROLE_ID));
                user.setEmail(email);
                user.setPassword(resultSet.getString(ColumnInfo.USER_PASSWORD));
            }
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);
        }finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.info("Unable to close resultSet");//TODO ??
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.info("Unable to close preparedStatement");
                }
            }
            if (connection != null) {
                try {
                    ConnectionManager.getPool().releaseConnection(connection);
                } catch (ConnectionPoolException e) {
                    logger.info("Unable to close connection");
                }
            }
        }

        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}

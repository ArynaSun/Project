package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.BaseDao;
import com.epam.jwt.task5.dao.specification.DaoSpecification;
import com.epam.jwt.task5.dao.exception.ConnectionPoolException;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.pool.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements BaseDao<User, ResultSet> {
    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    private static final int FIRST_ELEMENT_OF_LIST_INDEX = 0;

    @Override
    public void create(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_USER_EMAIL_PASSWORD_NAME_ROLE_ID_VALUES);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setInt(4, user.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error("Unable to close preparedStatement");
                }
            }
            if (connection != null) {
                try {
                    ConnectionManager.getPool().releaseConnection(connection);
                } catch (ConnectionPoolException e) {
                    logger.error("Unable to close connection");
                }
            }
        }
    }


    @Override
    public List<User> read(DaoSpecification<User, ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<User> user = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            user = specification.handleResult(resultSet);

        } catch (ConnectionPoolException | SQLException | SpecificationException e) {
            throw new DaoException(e);
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("Unable to close resultSet");
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error("Unable to close preparedStatement");
                }
            }
            if (connection != null) {
                try {
                    ConnectionManager.getPool().releaseConnection(connection);
                } catch (ConnectionPoolException e) {
                    logger.error("Unable to close connection");
                }
            }
        }

        return user;
    }

    @Override
    public User readBy(DaoSpecification<User, ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        User user = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            user = specification.handleResult(resultSet).get(FIRST_ELEMENT_OF_LIST_INDEX);

        } catch (ConnectionPoolException | SQLException | SpecificationException e) {
            throw new DaoException(e);
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("Unable to close resultSet");
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error("Unable to close preparedStatement");
                }
            }
            if (connection != null) {
                try {
                    ConnectionManager.getPool().releaseConnection(connection);
                } catch (ConnectionPoolException e) {
                    logger.error("Unable to close connection");
                }
            }
        }

        return user;
    }

    @Override
    public void update(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.UPDATE_USER_BY_ID);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setInt(4, user.getRoleId());
            preparedStatement.setInt(5, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error("Unable to close preparedStatement");
                }
            }
            if (connection != null) {
                try {
                    ConnectionManager.getPool().releaseConnection(connection);
                } catch (ConnectionPoolException e) {
                    logger.error("Unable to close connection");
                }
            }
        }

    }

    @Override
    public void delete(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.DELETE_FROM_USER_WHERE_ID);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error("Unable to close preparedStatement");
                }
            }
            if (connection != null) {
                try {
                    ConnectionManager.getPool().releaseConnection(connection);
                } catch (ConnectionPoolException e) {
                    logger.error("Unable to close connection");
                }
            }
        }

    }

    private static final class SqlQuery {
        private static final String INSERT_INTO_USER_EMAIL_PASSWORD_NAME_ROLE_ID_VALUES = "INSERT INTO user (email, password, name, role_id) VALUES (?, ?, ?, ?)";
        private static final String UPDATE_USER_BY_ID = "UPDATE user SET email = ?, password = ?, name = ?, role_id = ? WHERE id = ?";

        private static final String DELETE_FROM_USER_WHERE_ID = "DELETE FROM user WHERE id = ?";
    }
}

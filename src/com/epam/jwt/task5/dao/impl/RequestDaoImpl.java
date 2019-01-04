package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.Request;
import com.epam.jwt.task5.dao.BaseDao;
import com.epam.jwt.task5.dao.exception.ConnectionPoolException;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.exception.SpecificationException;
import com.epam.jwt.task5.dao.pool.ConnectionManager;
import com.epam.jwt.task5.dao.specification.DaoSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RequestDaoImpl implements BaseDao<Request, ResultSet> {

    private static final int FIRST_ELEMENT_OF_LIST_INDEX = 0;
    private static Logger logger = LogManager.getLogger(RequestDaoImpl.class);

    @Override
    public void create(Request entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_REQUEST_NAME_USER_ID_STATUS_ID_VALUES);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getUserId());
            preparedStatement.setInt(3, entity.getStatusId());
            preparedStatement.setInt(4, entity.getCourseId());
            preparedStatement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);//todo mes
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("Unable to close preparedStatement");
            }

            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.error("Unable to close connection");
            }
        }
    }

    @Override
    public Request readBy(DaoSpecification<Request, ResultSet> specification) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Request request = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            List<Request> requestList = specification.handleResult(resultSet);
            request = !requestList.isEmpty() ? requestList.get(FIRST_ELEMENT_OF_LIST_INDEX) : null;

        } catch (SQLException | SpecificationException | ConnectionPoolException e) {
            throw new DaoException(e);//todo mes
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("Unable to close resultSet");
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("Unable to close preparedStatement");
            }
            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.info("Unable to close connection");
            }
        }

        return request;
    }

    @Override
    public List<Request> read(DaoSpecification<Request, ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Request> requestList = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            requestList = specification.handleResult(resultSet);

        } catch (SQLException | SpecificationException | ConnectionPoolException e) {
            throw new DaoException(e);//todo mes
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("Unable to close resultSet");
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("Unable to close preparedStatement");
            }
            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.error("Unable to close connection");
            }
        }

        return requestList;
    }

    @Override
    public void update(Request entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.UPDATE_REQUEST);
            preparedStatement.setInt(5, entity.getId());
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getUserId());
            preparedStatement.setInt(3, entity.getStatusId());
            preparedStatement.setInt(4, entity.getCourseId());
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);//todo mes
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("Unable to close preparedStatement");
            }

            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.error("Unable to close connection");
            }
        }
    }

    @Override
    public void delete(Request entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.DELETE_FROM_REQUEST);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);//todo mes
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("Unable to close preparedStatement");
            }

            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.error("Unable to close connection");
            }
        }
    }

    private static final class SqlQuery {

        public static final String INSERT_INTO_REQUEST_NAME_USER_ID_STATUS_ID_VALUES = "INSERT INTO request " +
                "(name, user_id, status_id, course_id) VALUES (?, ?, ?, ?)";
        public static final String UPDATE_REQUEST = "UPDATE request SET name = ?, user_id = ?, status_id = ?, course_id = ? WHERE id = ? ";
        public static final String DELETE_FROM_REQUEST = "DELETE FROM request WHERE id = ?";
    }
}

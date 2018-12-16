package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.Subject;
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

public class SubjectDaoImpl implements BaseDao<Subject, ResultSet> {

    private static final int FIRST_ELEMENT_OF_LIST_INDEX = 0;

    private static Logger logger = LogManager.getLogger(SubjectDaoImpl.class);
    @Override
    public void create(Subject subject) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_SUBJECT_ID_NAME_VALUES);
            preparedStatement.setInt(1, subject.getId());
            preparedStatement.setString(2, subject.getName());
            preparedStatement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException("Ошибка уровня Dao", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.info("Unable to close preparedStatement");
            }

            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.info("Unable to close connection");
            }
        }
    }

    @Override
    public Subject readBy(DaoSpecification<Subject, ResultSet> specification) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Subject subject = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            subject = specification.handleResult(resultSet).get(FIRST_ELEMENT_OF_LIST_INDEX);
        } catch (SQLException | ConnectionPoolException | SpecificationException e) {
            throw new DaoException("Ошибка уровня Dao", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.info("Unable to close preparedStatement");
            }

            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.info("Unable to close connection");
            }
        }
        return subject;
    }

    @Override
    public List<Subject> read(DaoSpecification<Subject, ResultSet> specification) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Subject> subjectList = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            subjectList = specification.handleResult(resultSet);
        } catch (SQLException | ConnectionPoolException | SpecificationException e) {
            throw new DaoException("Ошибка уровня Dao", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.info("Unable to close preparedStatement");
            }

            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.info("Unable to close connection");
            }
        }
        return subjectList;
    }

    @Override
    public void update(Subject subject) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.UPDATE_SUBJECT);
            preparedStatement.setInt(1, subject.getId());
            preparedStatement.setString(2, subject.getName());
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException("Ошибка уровня Dao", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.info("Unable to close preparedStatement");
            }

            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.info("Unable to close connection");
            }
        }
    }

    @Override
    public void delete(Subject subject) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.DELETE_FROM_SUBJECT_WHERE_ID);
            preparedStatement.setInt(1, subject.getId());
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException("Ошибка уровня Dao", e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.info("Unable to close preparedStatement");
            }

            try {
                if (connection != null) {
                    ConnectionManager.getPool().releaseConnection(connection);
                }
            } catch (ConnectionPoolException e) {
                logger.info("Unable to close connection");
            }
        }
    }

    private static final class SqlQuery{

        private static final String INSERT_INTO_SUBJECT_ID_NAME_VALUES = "INSERT INTO subject (id, name) VALUES (?, ?)";
        private static final String UPDATE_SUBJECT = "UPDATE subject SET name = ? WHERE id = ?";
        private static final String DELETE_FROM_SUBJECT_WHERE_ID = "DELETE FROM subject WHERE id = ?";
    }
}

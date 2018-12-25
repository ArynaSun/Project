package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.Task;
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

public class TaskDaoImpl implements BaseDao<Task, ResultSet> {
    private static final int FIRST_ELEMENT_OF_LIST_INDEX = 0;

    private static Logger logger = LogManager.getLogger(TaskDaoImpl.class);

    @Override
    public void create(Task task) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_TASK_COURSE_ID_NAME_ATTACHMENTS_ASSIGNMENT_DATE_DEADLINE_VALUES);
            preparedStatement.setInt(1, task.getCourseId());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getAttachments());
            preparedStatement.setString(4, task.getAssignmentDate());
            preparedStatement.setString(5, task.getDeadline());
            preparedStatement.execute();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException("Ошибка уровня Dao", e);
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
    public Task readBy(DaoSpecification<Task, ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Task task = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            return specification.handleResult(resultSet).get(FIRST_ELEMENT_OF_LIST_INDEX);
        } catch (ConnectionPoolException | SQLException | SpecificationException e) {
            throw new DaoException("Ошибка уровня Dao", e);
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
    public List<Task> read(DaoSpecification specification) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            return specification.handleResult(resultSet);
        } catch (ConnectionPoolException | SQLException | SpecificationException e) {
            throw new DaoException("Ошибка уровня Dao", e);
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
    public void update(Task task) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.UPDATE_TASK);
            preparedStatement.setInt(1, task.getCourseId());
            preparedStatement.setString(2, task.getName());
            preparedStatement.setString(3, task.getAttachments());
            preparedStatement.setString(4, task.getAssignmentDate());
            preparedStatement.setString(5, task.getDeadline());
            preparedStatement.setInt(6,task.getId());

            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException("Ошибка уровня Dao", e);
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
    public void delete(Task task) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.DELETE_FROM_TASK_WHERE_ID);
            preparedStatement.setInt(1, task.getId());

            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException("Ошибка уровня Dao", e);
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

    private static final class SqlQuery{

        private static final String INSERT_INTO_TASK_COURSE_ID_NAME_ATTACHMENTS_ASSIGNMENT_DATE_DEADLINE_VALUES = "INSERT INTO task(course_id, name, attachments, assignment_date, deadline) VALUES (?, ?, ?, ?,?)";
        private static final String UPDATE_TASK = "UPDATE task SET course_id = ?,name = ?, attachments = ?, assignment_date = ?, deadline = ? WHERE id = ?";
        private static final String DELETE_FROM_TASK_WHERE_ID = "DELETE FROM task WHERE id = ?";
    }
}

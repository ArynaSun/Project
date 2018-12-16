package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.Solution;
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

public class SolutionDaoImpl implements BaseDao<Solution, ResultSet> {
    private static final int FIRST_ELEMENT_OF_LIST_INDEX = 0;

    private static Logger logger = LogManager.getLogger(SolutionDaoImpl.class);

    @Override
    public void create(Solution solution) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_SOLUTION);
            preparedStatement.setInt(1, solution.getStudentId());
            preparedStatement.setInt(2, solution.getTaskId());
            preparedStatement.setInt(3, solution.getMark());
            preparedStatement.setInt(4, solution.getStatusId());
            preparedStatement.setString(5, solution.getAnswer());
            preparedStatement.setString(6, solution.getAttachments());
            preparedStatement.setInt(7, solution.isAccepted() ? 1 : 0);
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
    public Solution readBy(DaoSpecification<Solution, ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Solution solution = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            solution = specification.handleResult(resultSet).get(FIRST_ELEMENT_OF_LIST_INDEX);
        } catch (SpecificationException| ConnectionPoolException | SQLException  e) {
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
        return solution;
    }

    @Override
    public List<Solution> read(DaoSpecification<Solution, ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Solution> solutionList = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            solutionList = specification.handleResult(resultSet);
        } catch (SpecificationException| ConnectionPoolException | SQLException  e) {
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
        return solutionList;
    }

    @Override
    public void update(Solution solution) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.UPDATE_SOLUTION);
            preparedStatement.setInt(1, solution.getId());
            preparedStatement.setInt(2, solution.getStudentId());
            preparedStatement.setInt(3, solution.getTaskId());
            preparedStatement.setInt(4, solution.getMark());
            preparedStatement.setInt(5, solution.getStatusId());
            preparedStatement.setString(6, solution.getAnswer());
            preparedStatement.setString(7, solution.getAttachments());
            preparedStatement.setInt(8, solution.isAccepted() ? 1 : 0);
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
    public void delete(Solution solution) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.DELETE_FROM_SOLUTION_WHERE_ID);
            preparedStatement.setInt(1, solution.getId());
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

    private static final class SqlQuery {

        private static final String INSERT_INTO_SOLUTION = "INSERT INTO solution " +
                "(student_id, task_id, mark, status_id, answer, attachments, is_accepted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        private static final String UPDATE_SOLUTION = "UPDATE solution SET student_id = ?, task_id = ?, " +
                "mark = ?, status_id = ?, answer = ?, attachments = ?, is_accepted = ? WHERE id = ?";
        private static final String DELETE_FROM_SOLUTION_WHERE_ID = "DELETE FROM solution WHERE id = ?";
    }
}

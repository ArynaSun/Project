package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.Review;
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

public class ReviewDaoImpl implements BaseDao<Review, ResultSet> {

    private static final int FIRST_ELEMENT_OF_LIST_INDEX = 0;

    private static Logger logger = LogManager.getLogger(ReviewDaoImpl.class);

    @Override
    public void create(Review entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_REVIEW_STUDENT_ID_COURSE_ID_MARK_DESCRIPTION_VALUES);
            preparedStatement.setInt(1, entity.getStudentId());
            preparedStatement.setInt(2, entity.getCourseId());
            preparedStatement.setInt(3, entity.getMark());
            preparedStatement.setString(4, entity.getDescription());
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
    public Review readBy(DaoSpecification<Review, ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Review review = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            review = specification.handleResult(resultSet).get(FIRST_ELEMENT_OF_LIST_INDEX);
        } catch (ConnectionPoolException | SQLException | SpecificationException  e) {
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
        return review;
    }

    @Override
    public List<Review> read(DaoSpecification<Review, ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Review> reviewList = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            reviewList = specification.handleResult(resultSet);
        } catch (ConnectionPoolException | SQLException | SpecificationException  e) {
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
        return reviewList;
    }

    @Override
    public void update(Review entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.UPDATE_REVIEW);

            preparedStatement.setInt(1, entity.getStudentId());
            preparedStatement.setInt(2, entity.getCourseId());
            preparedStatement.setInt(3, entity.getMark());
            preparedStatement.setString(4, entity.getDescription());
            preparedStatement.setInt(5,entity.getId());

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
    public void delete(Review entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.DELETE_FROM_REVIEW_WHERE_ID);
            preparedStatement.setInt(1, entity.getStudentId());
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
        private static final String DELETE_FROM_REVIEW_WHERE_ID = "DELETE FROM review WHERE id = ?";
        private static final String UPDATE_REVIEW = "UPDATE review SET student_id=?, course_id = ?, mark = ?, " +
                "description = ? WHERE id=?";
        private static final String INSERT_INTO_REVIEW_STUDENT_ID_COURSE_ID_MARK_DESCRIPTION_VALUES = "INSERT INTO " +
                "review(student_id, course_id, mark, description) VALUES (?, ?, ?, ?)";
    }
}

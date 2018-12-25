package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.dao.CourseDao;
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

public class CourseDaoImpl implements CourseDao {

    private static final int FIRST_ELEMENT_OF_LIST_INDEX = 0;
    private static Logger logger = LogManager.getLogger(CourseDaoImpl.class);

    @Override
    public void create(Course entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_COURSE_NAME_DESCRIPTION_TEACHER_ID_SUBJECT_ID_STATUS_ID_VALUES);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getTeacherId());
            preparedStatement.setInt(4, entity.getSubjectId());
            preparedStatement.setInt(5, entity.getStatusId());
            preparedStatement.execute();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
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
    public Course readBy(DaoSpecification<Course, ResultSet> specification) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Course course = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            course = specification.handleResult(resultSet).get(FIRST_ELEMENT_OF_LIST_INDEX);

        } catch (SQLException | ConnectionPoolException | SpecificationException e) {
            throw new DaoException(e);
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

        return course;
    }

    @Override
    public List<Course> read(DaoSpecification<Course,ResultSet> specification) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Course> course = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(specification.receiveInstruction());
            resultSet = preparedStatement.executeQuery();
            course = specification.handleResult(resultSet);

        } catch (SQLException | ConnectionPoolException | SpecificationException e) {
            throw new DaoException(e);
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

        return course;
    }

    @Override
    public void update(Course entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.UPDATE_COURSE);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getStatusId());
            preparedStatement.setInt(4, entity.getTeacherId());
            preparedStatement.setInt(5, entity.getSubjectId());
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
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
    public void delete(Course course) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.DELETE_FROM_COURSE_WHERE_ID);
            preparedStatement.setInt(1, course.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
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
                logger.error("Unable to close connection");
            }
        }
    }

    @Override
    public void addStudentToCourse(int courseId, int studentId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_COURSE_STUDENT_RELATION_VALUES
            );
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DaoException(e);
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
        private static final String UPDATE_COURSE = "UPDATE course SET name = ?, desription = ?, " +
                "status_id = ?, teacher_id = ?, subject_id = ? WHERE id = ?";
        private static final String DELETE_FROM_COURSE_WHERE_ID = "DELETE FROM course WHERE id = ?";
        private static final String INSERT_INTO_COURSE_NAME_DESCRIPTION_TEACHER_ID_SUBJECT_ID_STATUS_ID_VALUES =
                "INSERT INTO course(name, desription, teacher_id, subject_id, status_id) VALUES (?, ?, ?, ?, ?)";
        private static final String INSERT_INTO_COURSE_STUDENT_RELATION_VALUES =
                "INSERT INTO course_student_relation(student_id, course_id) VALUES(?,?)";
    }
}

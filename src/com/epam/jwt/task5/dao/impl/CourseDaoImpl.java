package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.dao.CourseDao;
import com.epam.jwt.task5.dao.exception.ConnectionPoolException;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.pool.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private static Logger logger = LogManager.getLogger(CourseDaoImpl.class);

    @Override
    public void create(Course entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO course(name, decription, teacher_id, subject_id, status_id) VALUES (?, ?, ?, ?, ?)");
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
    public Course readBy(int id) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Course course = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM course WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                course = new Course();
                course.setId(id);
                course.setName(resultSet.getString("name"));
                course.setDescription(resultSet.getString("description"));
                course.setStatusId(resultSet.getInt("status_id"));
                course.setSubjectId(resultSet.getInt("subject_id"));
                course.setTeacherId(resultSet.getInt("teacher_id"));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.info("Unable to close resultSet");
            }

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

        return course;
    }

    @Override
    public List<Course> readAll() throws DaoException {
        return null;
    }

    @Override
    public void update(Course entity) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE course SET name = ?, decription = ?, " +
                            "status_id = ?, teacher_id = ?, subject_id = ? WHERE id = ?");
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
    public void delete(Course entity) throws DaoException {

    }

    @Override
    public void addStudentToCourse(int courseId, int studentId) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getPool().takeConnection();
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO course_student_relation VALUES(?,?)"
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
}

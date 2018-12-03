package com.epam.jwt.task5.dao.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.DaoException;
import com.epam.jwt.task5.dao.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @Override
    public void create(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement(
                    SqlQuery.INSERT_INTO_USER_EMAIL_PASSWORD_NAME_ROLE_ID_VALUES);
            statement.setString(SqlColumnInfo.INSERT_EMAIL_INDEX, user.getEmail());
            statement.setString(SqlColumnInfo.INSERT_PASSWORD_INDEX, user.getPassword());
            statement.setString(SqlColumnInfo.INSERT_NAME_INDEX, user.getName());
            statement.setInt(SqlColumnInfo.INSERT_ROLE_ID_INDEX, user.getRoleId());
            statement.executeUpdate();
        } catch (ConnectionException | SQLException e) {
            e.printStackTrace();
            throw new DaoException(e);
        }finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.info("Unable to close statement");
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
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
    public User readBy(String email, String password) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        User user = null;
        ResultSet set = null;
        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement(
                    SqlQuery.SELECT_FROM_USER_WHERE_EMAIL_AND_PASSWORD);
            statement.setString(1,email);
            statement.setString(2,password);
            set = statement.executeQuery();
            if(set.next()){
                user = new User();
                user.setId(set.getInt(1));
                user.setRoleId(set.getInt(2));
                user.setName(set.getString(3));
                user.setEmail(set.getString(4));
                user.setPassword(set.getString(5));
            }

        } catch (ConnectionException | SQLException e) {
            e.printStackTrace();
            throw new DaoException(e);
        }finally {

            if(set != null){
                try {
                    set.close();
                } catch (SQLException e) {
                    logger.info("Unable to close set");
                }
            }

            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.info("Unable to close statement");
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
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

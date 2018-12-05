package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.DaoException;

public interface UserDao {
    void create(User user) throws DaoException;

    User readBy(int id);

    User readBy(String email, String password) throws DaoException;

    void update(User user);

    void delete(User user);
}

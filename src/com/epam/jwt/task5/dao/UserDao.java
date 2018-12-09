package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.DaoException;

public interface UserDao extends BaseDao<User>{

    User readBy(String email, String password) throws DaoException;

    User readBy(String email) throws DaoException;
}

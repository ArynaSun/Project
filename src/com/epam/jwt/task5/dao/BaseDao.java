package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.dao.exception.DaoException;

import java.util.List;

public interface BaseDao<T> {
    void create(T entity) throws DaoException;

    T readBy(int id) throws DaoException;

    List<T> readAll() throws DaoException;

    void update(T entity) throws DaoException;

    void delete(T entity) throws DaoException;
}

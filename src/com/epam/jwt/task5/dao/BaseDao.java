package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;

import java.util.List;

public interface BaseDao<T, E> {
    void create(T entity) throws DaoException;

    T readBy(DaoSpecification<T, E> specification) throws DaoException;

    List<T> read(DaoSpecification<T, E> specification) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(T entity) throws DaoException;
}

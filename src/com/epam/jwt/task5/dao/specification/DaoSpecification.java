package com.epam.jwt.task5.dao.specification;

import com.epam.jwt.task5.dao.exception.SpecificationException;

import java.util.List;

public interface DaoSpecification<T, E> {
    String receiveInstruction();

    List<T> handleResult(E result) throws SpecificationException;
}

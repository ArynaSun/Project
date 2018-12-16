package com.epam.jwt.task5.dao.specification;

import com.epam.jwt.task5.dao.specification.impl.CourseByIdSpecification;
import com.epam.jwt.task5.dao.specification.impl.UserByEmailPasswordSpecification;
import com.epam.jwt.task5.dao.specification.impl.UserByEmailSpecification;
import com.epam.jwt.task5.dao.specification.impl.UserByIdSpecification;

public class SpecificationFactory {
    public static DaoSpecification userById(int id){
        return new UserByIdSpecification(id);
    }

    public static DaoSpecification userByEmail(String email) {
        return new UserByEmailSpecification(email);
    }

    public static DaoSpecification userByEmailPassword(String email, String password) {
        return new UserByEmailPasswordSpecification(email, password);
    }


    public static DaoSpecification courseById(int id) {
        return new CourseByIdSpecification(id);
    }
}

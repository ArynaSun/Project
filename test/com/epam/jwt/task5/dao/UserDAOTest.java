package com.epam.jwt.task5.dao;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.specification.DaoSpecification;
import com.epam.jwt.task5.dao.specification.SpecificationFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class UserDAOTest extends Assert {

    private BaseDao<User, ?> userDao = DaoHelper.getUserDao();

    @Test
    public void userByEmailSpecificationPositiveTest() throws DaoException {
        String email = "test@test.ru";

        DaoSpecification specification = SpecificationFactory.userByEmail(email);
        User user = userDao.readBy(specification);

        assertNotNull(user);
    }
    @Test
    public void userByEmailSpecificationNegativeTest() throws DaoException {
        String email = "test1@test.ru";

        DaoSpecification specification = SpecificationFactory.userByEmail(email);
        User user = userDao.readBy(specification);

        assertNull(user);
    }
    @Test
    public void userByEmailAndPasswordSpecificationTest() throws DaoException {
        String email = "test@test.ru";
        String password = "password";

        DaoSpecification specification = SpecificationFactory.userByEmailPassword(email, password);
        User user = userDao.readBy(specification);

        assertNotNull(user);
    }
    @Test
    public void userByIdSpecificationTest() throws DaoException {
        int id = 1;

        DaoSpecification specification = SpecificationFactory.userById(id);
        User user = userDao.readBy(specification);

        assertNotNull(user);
    }
    @Test
    public void userByRoleIdSpecificationTest() throws DaoException {
        int roleId = 0;
        int expectedAdminListSize = 1;

        DaoSpecification specification = SpecificationFactory.usersByRoleId(roleId);
        List<User> adminList = userDao.read(specification);
        int actualAdminListSize = adminList.size();

        assertEquals(actualAdminListSize, expectedAdminListSize);
    }
}

package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.DaoException;
import com.epam.jwt.task5.dao.DaoManager;
import com.epam.jwt.task5.dao.UserDao;
import com.epam.jwt.task5.service.Action;
import com.epam.jwt.task5.service.JspPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationAction implements Action {

    private static Logger logger = LogManager.getLogger(RegistrationAction.class);

    @Override
    public JspPage carryOut(HttpServletRequest request, HttpServletResponse response) {

        UserDao userDao = DaoManager.getUserDao();

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setRoleId(3);

        try {
            userDao.create(user);
        } catch (DaoException e) {
            logger.info(e.getMessage());
            //TODO ERROR_PAGE
        }

        return JspPage.INDEX_PAGE;
    }
}

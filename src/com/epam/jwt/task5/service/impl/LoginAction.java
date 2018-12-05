package com.epam.jwt.task5.service.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.DaoManager;
import com.epam.jwt.task5.service.CourseAction;
import com.epam.jwt.task5.service.JspPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements CourseAction {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static Logger logger = LogManager.getLogger(LoginAction.class);

    @Override
    public JspPage carryOut(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);

        User user = null;

        try {
            user = DaoManager.getUserDao().readBy(email, password);
        } catch (DaoException e) {
            logger.info(e.getMessage());
            return JspPage.INDEX_PAGE;//TODO ERROR_PAGE
        }

        if(user != null){
            return JspPage.MAIN_PAGE;
        } else {
            return JspPage.INDEX_PAGE;
        }
    }
}

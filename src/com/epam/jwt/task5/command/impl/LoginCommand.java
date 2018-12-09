package com.epam.jwt.task5.command.impl;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public JspPage carryOut(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);

        User user = null;

        try {
            user = DaoHelper.getUserDao().readBy(email, password);
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

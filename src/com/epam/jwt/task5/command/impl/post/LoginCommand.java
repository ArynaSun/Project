package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.dao.specification.SpecificationFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements CourseCommand {//todo

    private static Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);

        User user = null;

        try {
            user = DaoHelper.getUserDao().readBy(SpecificationFactory.userByEmailPassword(email, password));
        } catch (DaoException e) {
            logger.info(e.getMessage());
            return JspPage.WELCOME_PAGE;//TODO ERROR_PAGE
        }

        if(user != null){
            return null; //JspPage.MAIN_PAGE;
        } else {
            return JspPage.WELCOME_PAGE;
        }
    }
}
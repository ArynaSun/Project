package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.command.*;
import com.epam.jwt.task5.dao.exception.DaoException;
import com.epam.jwt.task5.dao.DaoHelper;
import com.epam.jwt.task5.dao.specification.SpecificationFactory;
import com.epam.jwt.task5.service.CommonService;
import com.epam.jwt.task5.service.ServiceHelper;
import com.epam.jwt.task5.service.exception.ServiceException;
import com.epam.jwt.task5.service.exception.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);

        User user = null;

        JspPage jspPage;

        try {
            CommonService commonService = ServiceHelper.getCommonService();

            user = commonService.findUserBy(email, password);

        } catch (ServiceException e) {
            logger.error(LOG_ERROR_MESSAGE, e);

            return JspPage.ERROR_PAGE;

        } catch (ValidationException e) {
            jspPage = new JspPage(JspPage.WELCOME_PAGE, e.getMessage());

            return jspPage;
        }

        request.getSession().setAttribute(SessionAttribute.USER, user);

        switch (user.getRoleId()) {
            case 0:
                jspPage = JspPage.ADMIN_PAGE;
                break;
            case 1:
                jspPage = JspPage.TEACHER_PAGE;
                break;
            default:
                jspPage = JspPage.STUDENT_PAGE;
                break;
        }
        return jspPage;
    }
}

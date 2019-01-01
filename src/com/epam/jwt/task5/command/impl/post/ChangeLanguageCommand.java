package com.epam.jwt.task5.command.impl.post;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
import com.epam.jwt.task5.command.SessionAttribute;
import com.epam.jwt.task5.util.Language;
import com.epam.jwt.task5.util.LocaleHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguageCommand implements CourseCommand {

    private static Logger logger = LogManager.getLogger(ChangeLanguageCommand.class);

    @Override
    public JspPage execute(HttpServletRequest request, HttpServletResponse response) {

        String language = request.getParameter(RequestParameter.LANGUAGE).toUpperCase();
        request.getSession().setAttribute(SessionAttribute.LOCALE, Language.valueOf(language).getLocale());

        JspPage jspPage = (JspPage) request.getSession().getAttribute(SessionAttribute.LAST_OPEN_PAGE);

        return jspPage;
    }
}

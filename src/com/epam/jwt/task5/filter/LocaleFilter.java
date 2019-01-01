package com.epam.jwt.task5.filter;

import com.epam.jwt.task5.command.SessionAttribute;
import com.epam.jwt.task5.util.LocaleHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LocaleFilter extends BaseFilter {

    private static final String LANGUAGE = "ru";
    private static final String COUNTRY = "RU";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Locale locale = (Locale) session.getAttribute(SessionAttribute.LOCALE);
        if (locale == null) {
            locale = new Locale(LANGUAGE, COUNTRY);
            session.setAttribute(SessionAttribute.LOCALE, locale);
        }
        LocaleHelper.setLocale(locale);
    }
}

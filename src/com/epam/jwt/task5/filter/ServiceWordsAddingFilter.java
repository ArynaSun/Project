package com.epam.jwt.task5.filter;

import com.epam.jwt.task5.controller.ServiceWordsKey;
import com.epam.jwt.task5.util.PropertyHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceWordsAddingFilter extends BaseFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response) {

        if (!request.getMethod().toUpperCase().equals("GET")){
            return;
        }

        ServiceWordsKey[] values = ServiceWordsKey.values();

        for (ServiceWordsKey serviceWordsKey : values) {
            request.setAttribute(serviceWordsKey.name(), PropertyHelper.receiveServiceWord(serviceWordsKey.name()));
        }
    }
}

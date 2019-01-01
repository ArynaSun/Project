package com.epam.jwt.task5.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class EncodingFilter extends BaseFilter {

    private Logger logger = LogManager.getLogger(EncodingFilter.class);

    private static final String ENCODING = "UTF-8";

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setCharacterEncoding(ENCODING);
            request.setCharacterEncoding(ENCODING);
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
    }
}

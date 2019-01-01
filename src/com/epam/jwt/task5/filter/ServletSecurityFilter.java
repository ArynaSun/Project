package com.epam.jwt.task5.filter;

import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.SessionAttribute;
import com.epam.jwt.task5.command.impl.GetCommand;
import com.epam.jwt.task5.command.impl.PostCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ServletSecurityFilter extends BaseFilter {

    private static final List<String> ALLOWED_COMMANDS = Arrays.asList(
            PostCommand.LOGIN.name(),
            PostCommand.LOGOUT.name(),
            PostCommand.STUDENT_REGISTRATION.name(),
            PostCommand.CHANGE_LANGUAGE.name(),
            GetCommand.DISPLAY_WELCOME_PAGE.name(),
            GetCommand.DISPLAY_ERROR_PAGE.name()
    );

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        if ((session == null || session.getAttribute(SessionAttribute.USER) == null)
                && !isAllowedCommand(request.getParameter("command"))){
            response.sendRedirect(JspPage.WELCOME_PAGE.getRequestLine());
        }
    }

    private boolean isAllowedCommand(String command) {
        return command == null || ALLOWED_COMMANDS.contains(command.toUpperCase());
    }
}

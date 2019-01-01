package com.epam.jwt.task5.controller;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.SessionAttribute;
import com.epam.jwt.task5.command.impl.GetCommand;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.impl.PostCommand;
import com.epam.jwt.task5.util.LocaleHelper;
import com.epam.jwt.task5.util.PropertyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

import static com.epam.jwt.task5.command.RequestParameter.COMMAND;

public class Controller extends HttpServlet {

    private static Logger logger = LogManager.getLogger(Controller.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String command = request.getParameter(COMMAND);

            PostCommand postCommand = PostCommand.valueOf(command.toUpperCase());

            CourseCommand courseCommand = postCommand.getCommand();

            JspPage jspPage = courseCommand.execute(request, response);

            String requestLine = jspPage.getRequestLine();

            response.sendRedirect(requestLine);
        }catch (IllegalArgumentException | NullPointerException e){
            logger.error(e);
            response.sendRedirect(JspPage.ERROR_PAGE.getRequestLine());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String command = request.getParameter(COMMAND);

            GetCommand getCommand;

            if (command == null){
                getCommand = GetCommand.DISPLAY_WELCOME_PAGE;
            } else {
                getCommand = GetCommand.valueOf(command.toUpperCase());
            }

            CourseCommand courseCommand = getCommand.getCommand();

            JspPage jspPage = courseCommand.execute(request, response);

            request.getSession().setAttribute(SessionAttribute.LAST_OPEN_PAGE, jspPage);

            String jspPath = jspPage.getPath();

            if (!response.isCommitted()) {
                request.getServletContext().getRequestDispatcher(jspPath).forward(request, response);
            }

        }catch (IllegalArgumentException | NullPointerException e){
            logger.error(e);
            if (!response.isCommitted()) {
                response.sendRedirect(JspPage.ERROR_PAGE.getRequestLine());
            }
        }
    }
}

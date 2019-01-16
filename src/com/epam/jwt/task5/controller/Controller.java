package com.epam.jwt.task5.controller;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.SessionAttribute;
import com.epam.jwt.task5.command.impl.GetCommand;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.impl.PostCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.jwt.task5.command.RequestParameter.COMMAND;

/**
 * @version 1
 * A Controller instance handle http requests
 * Now GET and POST methods are implemented
 */
public class Controller extends HttpServlet {

    private static Logger logger = LogManager.getLogger(Controller.class);

    /**
     That method is used to
     handle POST requests
     @param request - HttpRequest
     @param response - HttpResponse
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String command = request.getParameter(COMMAND);

            PostCommand postCommand = PostCommand.valueOf(command.toUpperCase());

            CourseCommand courseCommand = postCommand.getCommand();

            JspPage jspPage = courseCommand.execute(request, response);

            String requestLine = jspPage.getRequestLine();

            if (!response.isCommitted()) {
                response.sendRedirect(requestLine);
            }
        }catch (IllegalArgumentException | NullPointerException e){
            logger.error(e);
            if (!response.isCommitted()) {
                response.sendRedirect(JspPage.ERROR_PAGE.getRequestLine());
            }
        }
    }

    /**
     That method is used to
     handle GET requests
     @param request - HttpRequest
     @param response - HttpResponse
     */
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

            JspPage previousPage = (JspPage) request.getSession().getAttribute(SessionAttribute.CURRENT_PAGE);
            if (!jspPage.equals(previousPage)) {
                request.getSession().setAttribute(SessionAttribute.LAST_OPEN_PAGE, previousPage);
            }
            request.getSession().setAttribute(SessionAttribute.CURRENT_PAGE, jspPage);

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

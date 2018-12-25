package com.epam.jwt.task5.controller;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.impl.GetCommand;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.impl.PostCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.epam.jwt.task5.command.RequestParameter.COMMAND;

public class Controller extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String command = request.getParameter(COMMAND);
            PostCommand postCommand = PostCommand.valueOf(command.toUpperCase());
            CourseCommand courseCommand = postCommand.getCommand();
            JspPage jspPage = courseCommand.execute(request, response);
            String requestLine = jspPage.getRequestLine();
            response.sendRedirect(requestLine);
        }catch (IllegalArgumentException | NullPointerException e){
            response.sendRedirect(JspPage.ERROR_PAGE.getRequestLine());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String command = request.getParameter(COMMAND);
            GetCommand getCommand = GetCommand.valueOf(command.toUpperCase());
            CourseCommand courseCommand = getCommand.getCommand();
            JspPage jspPage = courseCommand.execute(request, response);
            String jspPath = jspPage.getPath();
            request.getServletContext().getRequestDispatcher(jspPath).forward(request, response);
        }catch (IllegalArgumentException | NullPointerException e){
            response.sendRedirect(JspPage.ERROR_PAGE.getRequestLine());
        }
    }
}

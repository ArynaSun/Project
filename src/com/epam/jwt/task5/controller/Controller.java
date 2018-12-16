package com.epam.jwt.task5.controller;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.GetCommand;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.PostCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final String COMMAND = "command";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);
        try {
            PostCommand postCommand = PostCommand.valueOf(command.toUpperCase());
            CourseCommand courseCommand = postCommand.getCommand();
            JspPage jspPage = courseCommand.execute(request, response);
            String requestLine = jspPage.getRequestLine();
            response.sendRedirect(requestLine);
        }catch (IllegalArgumentException e){
            //todo error page
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);
        try {
            GetCommand getCommand = GetCommand.valueOf(command.toUpperCase());
            CourseCommand courseCommand = getCommand.getCommand();
            JspPage jspPage = courseCommand.execute(request, response);
            String jspPath = jspPage.getPath();
            request.getServletContext().getRequestDispatcher(jspPath).forward(request, response);
        }catch (IllegalArgumentException e){
            //todo error page
        }
    }
}

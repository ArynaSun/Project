package com.epam.jwt.task5.controller;

import com.epam.jwt.task5.command.impl.LoginCommand;
import com.epam.jwt.task5.command.impl.StudentRegistrationCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final String COMMAND = "command";
    private static final String LOGIN = "login";
    private static final String REGISTRATION = "registration";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);
        String jspPath = "";//TODO ERROR_PAGE
        if (command.equals(LOGIN)) {
            jspPath = new LoginCommand().carryOut(request, response).getPath();
        }else if (command.equals(REGISTRATION)){
            jspPath = new StudentRegistrationCommand().carryOut(request, response).getPath();
        }
       request.getServletContext().getRequestDispatcher(jspPath).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("!!!!!!!!!!!!!!");
        response.getWriter().append("My Web");
        request.getServletContext().getRequestDispatcher("/jsp/mainPage.jsp").forward(request, response);
    }
}

package com.epam.jwt.task5.filter;

import com.epam.jwt.task5.bean.Course;
import com.epam.jwt.task5.bean.Role;
import com.epam.jwt.task5.bean.User;
import com.epam.jwt.task5.command.JspPage;
import com.epam.jwt.task5.command.RequestParameter;
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

    private static final List<String> COMMON_COMMANDS = Arrays.asList(
            PostCommand.LOGIN.name(),
            PostCommand.LOGOUT.name(),
            PostCommand.STUDENT_REGISTRATION.name(),
            PostCommand.CHANGE_LANGUAGE.name(),
            PostCommand.BACK.name(),

            GetCommand.DISPLAY_WELCOME_PAGE.name(),
            GetCommand.DISPLAY_ERROR_PAGE.name()
    );

    private static final List<String> STUDENT_COMMANDS = Arrays.asList(
            GetCommand.DISPLAY_COURSE_INFO_PAGE.name(),
            GetCommand.DISPLAY_STUDENT_PAGE.name(),

            PostCommand.REQUEST_TO_REGISTRATION.name(),
            PostCommand.SEND_SOLUTION.name()
    );

    private static final List<String> TEACHER_COMMANDS = Arrays.asList(
            GetCommand.DISPLAY_COURSE_INFO_PAGE.name(),
            GetCommand.DISPLAY_STUDENT_INFO_PAGE.name(),
            GetCommand.DISPLAY_TEACHER_PAGE.name(),

            PostCommand.ADDING_REVIEW_TO_STUDENT.name(),
            PostCommand.ADDING_TASK_TO_COURSE.name(),
            PostCommand.CHECK_SOLUTION.name(),
            PostCommand.COMPLETE_COURSE_REQUEST.name()

    );

    private static final List<String> ADMIN_COMMANDS = Arrays.asList(
            GetCommand.DISPLAY_COURSE_INFO_PAGE.name(),
            GetCommand.DISPLAY_STUDENT_INFO_PAGE.name(),
            GetCommand.DISPLAY_ADMIN_PAGE.name(),

            PostCommand.ADDING_COURSE.name(),
            PostCommand.ADDING_STUDENT_TO_COURSE.name(),
            PostCommand.CHANGE_COURSE_STATUS.name(),
            PostCommand.CHANGE_COURSE_TEACHER.name(),
            PostCommand.REJECT_REQUEST.name(),
            PostCommand.TEACHER_REGISTRATION.name()
    );
    private static final int ADMIN_ID = 0;
    private static final int TEACHER_ID = 1;
    private static final int STUDENT_ID = 2;


    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        String command = request.getParameter(RequestParameter.COMMAND);
        if (command == null) {
            command = GetCommand.DISPLAY_WELCOME_PAGE.name();
        } else {
            command = command.toUpperCase();
        }

        User user = session != null ? (User) session.getAttribute(SessionAttribute.USER) : null;

        Integer roleId = user != null ? user.getRoleId() : null;

        if (!isAllowedCommand(command, user, roleId)) {
            response.sendRedirect(JspPage.WELCOME_PAGE.getRequestLine());
        }
    }

    private boolean isAllowedCommand(String command, User user, Integer roleId) {
        if (user == null) {
            return COMMON_COMMANDS.contains(command);
        } else {
            switch (roleId) {
                case ADMIN_ID: {
                    return COMMON_COMMANDS.contains(command) || ADMIN_COMMANDS.contains(command);
                }
                case TEACHER_ID: {
                    return COMMON_COMMANDS.contains(command)|| TEACHER_COMMANDS.contains(command);
                }
                case STUDENT_ID: {
                    return COMMON_COMMANDS.contains(command)|| STUDENT_COMMANDS.contains(command);
                }
            }
        }
        return false;
    }
}

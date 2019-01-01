package com.epam.jwt.task5.command.impl;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.impl.get.*;

public enum GetCommand {
    DISPLAY_ADMIN_PAGE(new DisplayAdminPageCommand()),
    DISPLAY_COURSE_INFO_PAGE(new DisplayCourseInfoCommand()),
    DISPLAY_STUDENT_INFO(new DisplayStudentInfoCommand()),
    DISPLAY_TEACHER_PAGE(new DisplayTeacherPageCommand()),
    DISPLAY_STUDENT_PAGE(new DisplayStudentPageCommand()),
    DISPLAY_WELCOME_PAGE(new DisplayWelcomePageCommand()),
    DISPLAY_ERROR_PAGE(new DisplayErrorPageCommand());

    private final CourseCommand command;

    GetCommand(CourseCommand command) {
        this.command = command;
    }

    public CourseCommand getCommand() {
        return command;
    }
}

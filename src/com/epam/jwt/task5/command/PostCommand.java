package com.epam.jwt.task5.command;

import com.epam.jwt.task5.command.impl.LoginCommand;

public enum PostCommand {
    LOGIN(new LoginCommand());

    private final CourseCommand command;

    PostCommand(CourseCommand command) {
        this.command = command;
    }

    public CourseCommand getCommand() {
        return command;
    }
}

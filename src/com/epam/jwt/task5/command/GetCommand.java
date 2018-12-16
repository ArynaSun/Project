package com.epam.jwt.task5.command;

public enum GetCommand {
    DISPLAY_ADMIN_PAGE(null);//TODO Display admin command

    private final CourseCommand command;

    GetCommand(CourseCommand command) {
        this.command = command;
    }

    public CourseCommand getCommand() {
        return command;
    }
}

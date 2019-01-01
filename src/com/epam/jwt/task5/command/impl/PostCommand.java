package com.epam.jwt.task5.command.impl;

import com.epam.jwt.task5.command.CourseCommand;
import com.epam.jwt.task5.command.impl.post.*;

public enum PostCommand {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    ADDING_COURSE(new AddingCourseCommand()),
    ADDING_REVIEW_TO_STUDENT(new AddingReviewToStudentCommand()),
    ADDING_STUDENT_TO_COURSE(new AddingStudentToCourseCommand()),
    ADDING_TASK_TO_COURSE(new AddingTaskToCourseCommand()),
    CHANGE_COURSE_STATUS(new ChangeCourseStatusCommand()),
    CHANGE_COURSE_TEACHER(new ChangeCourseTeacherCommand()),
    CHECK_SOLUTION(new CheckSolutionCommand()),
    COMPLETE_COURSE_REQUEST(new CompleteCourseRequestCommand()),
    HANDLE_REQUEST(new HandleRequestCommand()),
    REQUEST_TO_REGISTRATION(new RequestToRegistrationCommand()),
    SEND_SOLUTION(new SendSolutionCommand()),
    STUDENT_REGISTRATION(new StudentRegistrationCommand()),
    TEACHER_REGISTRATION(new TeacherRegistrationCommand()),
    CHANGE_LANGUAGE(new ChangeLanguageCommand());

    private final CourseCommand command;

    PostCommand(CourseCommand command) {
        this.command = command;
    }

    public CourseCommand getCommand() {
        return command;
    }
}

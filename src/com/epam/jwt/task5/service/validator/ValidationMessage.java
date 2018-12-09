package com.epam.jwt.task5.service.validator;

public interface ValidationMessage {

    String USER_EXISTS_MESSAGE = "Пользователь с таким email уже существует!";
    String NOT_VALID_NAME_MESSAGE = "Неверный формат имени";
    String NOT_VALID_NAME_COURSE_MESSAGE = "Неверный формат названия курса";
    String NOT_VALID_DESCRIPTION_COURSE_MESSAGE = "Неверный формат описания курса";
    String NOT_VALID_EMAIL_MESSAGE = "Неверный формат e-mail";
    String NOT_VALID_PASSWORD_MESSAGE = "Неверный формат пароля";
    String HACKER_HELLO_MESSAGE = "Так делать нельзя, а то а-та-та!!! :)";
}

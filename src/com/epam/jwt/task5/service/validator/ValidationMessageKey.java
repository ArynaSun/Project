package com.epam.jwt.task5.service.validator;

import static com.epam.jwt.task5.service.validator.impl.BaseServiceValidator.MAX_MARK;
import static com.epam.jwt.task5.service.validator.impl.BaseServiceValidator.MIN_MARK;

public interface ValidationMessageKey {

    String USER_EXISTS_MESSAGE = "Пользователь с таким email уже существует!";
    String NOT_VALID_NAME_MESSAGE = "Неверный формат имени";
    String NOT_VALID_NAME_COURSE_MESSAGE = "NOT_VALID_NAME_COURSE_MESSAGE";
    String NOT_VALID_DESCRIPTION_MESSAGE = "Описание не должно быть пустым!";//todo не могу придумать другое
    String NOT_VALID_EMAIL_MESSAGE = "Неверный формат e-mail";
    String NOT_VALID_PASSWORD_MESSAGE = "Неверный формат пароля";
    String HACKER_HELLO_MESSAGE = "Так делать нельзя, а то а-та-та!!! :)";
    String INVALID_MARK_MESSAGE = "Оценка должна быть от " + MIN_MARK + "до " + MAX_MARK + "!";//todo big question
    String INVALID_ANSWER_MESSAGE = "Неверный формат ответа!";
    String INVALID_DATE_FORMATE_MESSAGE = "Неверный формат даты!";
}

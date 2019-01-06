package com.epam.jwt.task5.dao.specification.impl;

public interface ColumnInfo {
    String USER_ID = "id";
    String USER_ROLE_ID = "role_id";
    String USER_NAME = "name";
    String USER_PASSWORD = "password";
    String USER_EMAIL = "email";

    String COURSE_ID = "id";
    String COURSE_NAME = "name";
    String COURSE_DESCRIPTION = "description";
    String COURSE_STATUS_ID = "status_id";
    String COURSE_SUBJECT_ID = "subject_id";
    String COURSE_TEACHER_ID = "teacher_id";

    String REQUEST_ID = "id";
    String REQUEST_NAME = "name";
    String REQUEST_STATUS_ID = "status_id";
    String REQUEST_USER_ID = "user_id";
    String REQUEST_COURSE_ID = "course_id";

    String SOLUTION_STUDENT_ID = "student_id";
    String SOLUTION_TASK_ID = "task_id";
    String SOLUTION_MARK = "mark";
    String SOLUTION_ANSWER = "answer";
    String SOLUTION_ATTACHMENTS = "attachments";
    String SOLUTION_IS_ACCEPTED = "is_accepted";
    String SOLUTION_ID = "id";

    String TASK_ID = "id";
    String TASK_NAME = "name";
    String TASK_ATTACHMENTS = "attachments";
    String TASK_ASSIGNMENT_DATE = "assignment_date";
    String TASK_DEADLINE = "deadline";

    String REVIEW_ID = "id";
    String REVIEW_COURSE_ID = "course_id";
    String REVIEW_MARK = "mark";
    String REVIEW_DESCRIPTION = "description";

    String SUBJECT_NAME = "name" ;
    String SUBJECT_ID = "id";
}


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<div id="header">
    <jsp:include page="module/header.jsp"/>
</div>
<main role="main" class="container">
    <div class="jumbotron">
        <div id="add_course">
            <jsp:include page="module/forms/add_course.jsp"/>
        </div>
        <hr>
        <div id="add_teacher">
            <jsp:include page="module/forms/add_teacher.jsp"/>
        </div>
        <hr>
        <div id="planned_courses">
            <jsp:include page="module/views/courses_planned.jsp"/>
        </div>
        <div id="active_courses">
            <jsp:include page="module/views/courses_active.jsp"/>
        </div>
        <hr>
        <div id="completed_courses">
            <jsp:include page="module/views/courses_completed.jsp"/>
        </div>
        <hr>
        <div id="teachers">
            <jsp:include page="module/views/users_teachers.jsp"/>
        </div>
        <hr>
            <div id="student_requests">
                <jsp:include page="module/views/requests_student.jsp"/>
            </div>
            <hr>
            <div id="teacher_requests">
                <jsp:include page="module/views/requests_teacher.jsp"/>
            </div>
    </div>
</main>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div id="server_message">
    <jsp:include page="module/views/server_message.jsp"/>
</div>
<hr>
<div id="logout">
    <jsp:include page="module/forms/logout.jsp"/>
</div>
<div id="planned_courses">
    <jsp:include page="module/views/courses_planned.jsp"/>
</div>
<div id="add_course">
    <jsp:include page="module/forms/add_course.jsp"/>
</div>
<hr>
<div id="active_courses">
    <jsp:include page="module/views/courses_active.jsp"/>
</div>
<hr>
<div id="completed_courses">
    <jsp:include page="module/views/courses_active.jsp"/>
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
<hr>
</body>
</html>

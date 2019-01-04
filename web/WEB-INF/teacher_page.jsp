<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="css/teacher_page.css">
</head>
<body>
<div id="header">
    <jsp:include page="module/header.jsp"/>
</div>
<div id="planned_courses">
    <jsp:include page="module/views/courses_planned.jsp"/>
</div>
<hr>
<div id="active_courses">
    <jsp:include page="module/views/courses_active.jsp"/>
</div>
<div id="teacher_course">
    <jsp:include page="module/views/card_teacher_course.jsp"/>
</div>
</body>
</html>

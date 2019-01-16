<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="courses" uri="/WEB-INF/tag/courses.tld" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
<div id="header">
    <jsp:include page="module/header.jsp"/>
</div>
<hr>
<main role="main" class="container">
    <div class="jumbotron">
        <div id="planned_courses">
            <jsp:include page="module/views/courses_planned.jsp"/>
        </div>
        <hr>
        <div id="student_courses">
            <jsp:include page="module/views/courses_student.jsp"/>
        </div>
        <hr>
    </div>
</main>
<courses:footer/>
</body>
</html>

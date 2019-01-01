<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>
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
<div id="students">
    <jsp:include page="module/views/users_students.jsp"/>
</div>
<hr>
<div id="tasks">
    <jsp:include page="module/views/tasks.jsp"/>
</div>
<hr>
<div id="course_info">
    <jsp:include page="module/views/card_course.jsp"/>
</div>
<hr>
<div id="task_solutions">
    <jsp:include page="module/views/task_solutions.jsp"/>
</div>
</body>
</html>

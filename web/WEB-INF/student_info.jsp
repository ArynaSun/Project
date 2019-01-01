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
<hr>
<div id="change_language">
    <jsp:include page="module/forms/change_language.jsp"/>
</div>
<hr>
<div id="completed_courses">
    <jsp:include page="module/views/courses_completed.jsp"/>
</div>
<hr>
<div id="student_reviews">
    <jsp:include page="module/views/student_reviews.jsp"/>
</div>
<hr>
<div id="student_info">
    <jsp:include page="module/views/card_student.jsp"/>
</div>
<hr>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div id="server_message">
    <jsp:include page="module/views/server_message.jsp"/>
</div>
<hr>
<div id="change_language">
    <jsp:include page="module/forms/change_language.jsp"/>
</div>
<hr>
<div id="planned_courses">
    <jsp:include page="module/views/courses_planned.jsp"/>
</div>
<hr>
<div id="login">
    <jsp:include page="module/forms/login.jsp"/>
</div>
<hr/>
<div id="registration">
    <jsp:include page="module/forms/registration.jsp"/>
</div>
</body>
</html>
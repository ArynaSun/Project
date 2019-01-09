<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div id="header">
    <jsp:include page="module/header.jsp"/>
</div>

<div id="main">
    <c:if test="${sessionScope.user.roleId == 0}">
        <jsp:include page="module/links/show_admin.jsp"/>
    </c:if>

    <c:if test="${sessionScope.user.roleId == 2}">
        <jsp:include page="module/links/show_student.jsp"/>
    </c:if>

    <c:if test="${sessionScope.user.roleId == 1}">
        <jsp:include page="module/links/show_teacher.jsp"/>
    </c:if>
</div>
<div id="student_info">
    <jsp:include page="module/views/card_student.jsp"/>
    <hr>
</div>
<div id="student_reviews">
    <jsp:include page="module/views/student_reviews.jsp"/>
    <hr>
</div>
<div id="completed_courses">
    <jsp:include page="module/views/courses_completed.jsp"/>
    <hr>
</div>
</body>
</html>

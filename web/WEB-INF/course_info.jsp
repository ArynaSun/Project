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
<c:if test="${sessionScope.user.roleId == 1 && sessionScope.user.id == Course.course.teacherId}">
    <div id="add_task">
        <jsp:include page="module/forms/add_task.jsp"/>
    </div>
    <div id="add_review">
        <jsp:include page="module/forms/add_review.jsp"/>
    </div>
    <div id="request_teacher">
        <jsp:include page="module/forms/request_teacher.jsp"/>
    </div>
</c:if>
<c:if test="${sessionScope.user.roleId == 0}">
    <div id="change_course_status">
        <jsp:include page="module/forms/change_course_status.jsp"/>
    </div>
</c:if>
<div id="course_info">
    <jsp:include page="module/views/card_course.jsp"/>
</div>
<hr>
<div id="students">
    <jsp:include page="module/views/users_students.jsp"/>
</div>
<hr>
<div id="tasks">
    <c:if test="${sessionScope.user.roleId == 0}">
        <jsp:include page="module/views/tasks.jsp"/>
    </c:if>
    <c:if test="${sessionScope.user.roleId == 1}">
        <jsp:include page="module/views/tasks_solutions.jsp"/>
    </c:if>
    <c:if test="${sessionScope.user.roleId == 2}">
        <jsp:include page="module/views/tasks_solution.jsp"/>
    </c:if>
</div>
<hr>
</body>
</html>

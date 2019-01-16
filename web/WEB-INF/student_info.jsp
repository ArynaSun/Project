<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<main role="main" class="container">
    <div class="jumbotron">
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
    </div>
</main>
<courses:footer/>
</body>
</html>

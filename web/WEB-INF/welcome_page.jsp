<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body >
<div id="header">
    <jsp:include page="module/header.jsp"/>
</div>
<main role="main" class="container">
    <div class="jumbotron">

        <div id="planned_courses">
            <jsp:include page="module/views/courses_planned.jsp"/>
        </div>
        <hr>
        <div  class="text-center" id="login">
            <jsp:include page="module/forms/login.jsp"/>
        </div>
        <hr/>
        <div id="registration">
            <jsp:include page="module/forms/registration.jsp"/>
        </div>
    </div>
</main>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_course_info" class="table-responsive">
    <h3>${COURSE_DATA}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>${COURSE_NAME}</th>
            <th>${COURSE_DESCRIPTION}</th>
            <th>${TEACHER}</th>
            <th>${SUBJECT}</th>
        </tr>
        </thead>
        <%--@elvariable id="CompletedCourses" type="java.util.List"--%>
        <tbody>
        <tr>
            <td><c:out value="${Course.course.name}"/></td>
            <td><c:out value="${Course.course.description}"/></td>
            <td><c:out value="${Course.teacherName}"/></td>
            <td><c:out value="${Course.subjectName}"/></td>
        </tr>
        </tbody>
    </table>
</div>

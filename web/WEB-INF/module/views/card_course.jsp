<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_course_info">
    <h3>${COURSE_DATA}</h3>
    <table>
        <tr>
            <td>${COURSE_NAME}</td>
            <td>${COURSE_DESCRIPTION}</td>
            <td>${TEACHER}</td>
            <td>${SUBJECT}</td>
        </tr>
        <%--@elvariable id="CompletedCourses" type="java.util.List"--%>
        <tr>
            <td><c:out value="${Course.course.name}"/></td>
            <td><c:out value="${Course.course.description}"/></td>
            <td><c:out value="${Course.teacherName}"/></td>
            <td><c:out value="${Course.subjectName}"/></td>
        </tr>
    </table>
</div>

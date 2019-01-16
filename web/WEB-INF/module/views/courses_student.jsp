<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_student_courses" class="table-responsive">
    <h3>${STUDENT_COURSES}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>${COURSE_NAME}</th>
            <th>${COURSE_DESCRIPTION}</th>
            <th>${SUBJECT}</th>
            <th>${TEACHER}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="courseDTO" items="${StudentCourses}" varStatus="i">
            <tr>
                <td><c:out value="${courseDTO.course.name}"/></td>
                <td><c:out value="${courseDTO.course.description}"/></td>
                <td><c:out value="${courseDTO.teacherName}"/></td>
                <td><c:out value="${courseDTO.subjectName}"/></td>
                <td>
                    <a href="http://localhost:8080/controller?command=DISPLAY_COURSE_INFO_PAGE&course_id=${courseDTO.course.id}">
                            ${DISPLAY}
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_student_courses">
    <h3>${STUDENT_COURSES}</h3>
    <table>
        <tr>
            <td>${COURSE_NAME}</td>
            <td>${COURSE_DESCRIPTION}</td>
            <td>${TEACHER}</td>
            <td>${SUBJECT}</td>
        </tr>
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
    </table>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_completed_courses">
    <h3>${COMPLETED_COURSES_LABEL}</h3>
    <table>
        <%--@elvariable id="CompletedStudentCourses" type="java.util.List"--%>
        <c:forEach var="courseDTO" items="${CompletedStudentCourses}" varStatus="i">
            <tr>
                <td><c:out value="${courseDTO.course.name}"/></td>
                <td><c:out value="${courseDTO.course.description}"/></td>
                <td><c:out value="${courseDTO.subjectName}"/></td>
                <td><c:out value="${courseDTO.teacherName}"/></td>
            </tr>
            <a href="http://localhost:8080/controller?command=DISPLAY_COURSE_INFO_PAGE&course_id=${courseDTO.course.id}">
                    ${DISPLAY}
            </a>
        </c:forEach>
    </table>
</div>

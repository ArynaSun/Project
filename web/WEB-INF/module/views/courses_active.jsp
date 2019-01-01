<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_active_courses">
    <h3>${ACTIVE_COURSES_LABEL}</h3>
    <table>
        <%--@elvariable id="ActiveCourses" type="java.util.List"--%>
        <c:forEach var="course" items="${ActiveCourses}" varStatus="i">
            <tr>
                <td><c:out value="${course.name}"/></td>
                <td><c:out value="${course.description}"/></td>
                <td><c:out value="${courseDTO.subjectName}"/></td>
                <td><c:out value="${courseDTO.teacherName}"/></td>
            </tr>
            <a href="http://localhost:8080/controller?command=DISPLAY_COURSE_INFO_PAGE&course_id=${course.id}">
                    ${DISPLAY}
            </a>
        </c:forEach>
    </table>
</div>

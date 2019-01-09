<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_active_courses">
    <h3>${ACTIVE_COURSES_LABEL}</h3>
    <table>
        <thead>
        <tr>
            <td>${COURSE_NAME}</td>
            <td>${COURSE_DESCRIPTION}</td>
            <td>${SUBJECT}</td>
            <td>${TEACHER}</td>
        </tr>
        </thead>
        <%--@elvariable id="ActiveCourses" type="java.util.List"--%>
        <tbody>
        <c:forEach var="courseDTO" items="${ActiveCourses}" varStatus="i">
            <tr>
                <td><c:out value="${courseDTO.course.name}"/></td>
                <td><c:out value="${courseDTO.course.description}"/></td>
                <td><c:out value="${courseDTO.subjectName}"/></td>
                <td><c:out value="${courseDTO.teacherName}"/></td>
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

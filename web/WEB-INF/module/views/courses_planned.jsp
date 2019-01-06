<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_planned_courses">
    <h3>${PLANNED_COURSES_LABEL}</h3>
    <table>
        <tr>
            <td>${COURSE_NAME}</td>
            <td>${COURSE_DESCRIPTION}</td>
            <td>${SUBJECT}</td>
            <td>${TEACHER}</td>
        </tr>
        <%--@elvariable id="PlannedCourses" type="java.util.List"--%>
        <c:forEach var="courseDTO" items="${PlannedCourses}" varStatus="i">
            <tr>
                <td><c:out value="${courseDTO.course.name}"/></td>
                <td><c:out value="${courseDTO.course.description}"/></td>
                <td><c:out value="${courseDTO.subjectName}"/></td>
                <td><c:out value="${courseDTO.teacherName}"/></td>
                <c:if test="${sessionScope.user != null}">
                    <td>
                        <a class="link-course"
                           href="http://localhost:8080/controller?command=DISPLAY_COURSE_INFO_PAGE&course_id=${courseDTO.course.id}">
                                ${DISPLAY}
                        </a>
                    </td>
                    <c:if test="${sessionScope.user.roleId == 2}">
                        <td>
                            <jsp:include page="../forms/request_student.jsp"/>
                        </td>
                    </c:if>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>${PLANNED_COURSES_LABEL}</h3>
<div id="_planned_courses" class="table-responsive">
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
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="REQUEST_TO_REGISTRATION">
                                <input type="hidden" name="course_id" value="${courseDTO.course.id}">
                                <input type="hidden" name="user_id" value="${sessionScope.user.id}">
                                <input type="submit" value="${SEND_REQUEST}">
                            </form>
                        </td>
                    </c:if>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

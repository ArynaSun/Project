<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id=_select_course_statuses">
    <select name="course_status_id">
        <c:forEach var="courseStatus" items="${CourseStatuses}" varStatus="i">
            <option value="${courseStatus.id}">
                    ${courseStatus.statusName}
            </option>
        </c:forEach>
    </select>
</div>
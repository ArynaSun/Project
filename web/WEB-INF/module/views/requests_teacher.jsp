<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_teacher_requests">
    <h3>${REQUESTS_TO_COMPLETE_COURSE}</h3>
    <table>
        <%--@elvariable id="StudentRequests" type="java.util.List"--%>
        <c:forEach var="requestDTO" items="${StudentRequests}" varStatus="i">
            <tr>
                <td><c:out value="${requestDTO.request.name}"/></td>
                <td><c:out value="${requestDTO.userName}"/></td>
                <td><c:out value="${requestDTO.courseName}"/></td>
                <td><c:out value="${requestDTO.statusName}"/></td>>
            </tr>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="CHANGE_COURSE_STATUS">
                <input type="hidden" name="course_status_id" value="3">
                <input type="hidden" name="course_id" value="${request.courseId}">
                <input type="submit" value="${SUBMIT}">
            </form>
        </c:forEach>
    </table>
</div>

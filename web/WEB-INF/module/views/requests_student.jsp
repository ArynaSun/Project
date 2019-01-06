<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_student_requests">
    <h3>${REQUESTS_TO_REGISTRATION} </h3>
    <table>
        <%--@elvariable id="StudentRequests" type="java.util.List"--%>
        <c:forEach var="requestDTO" items="${StudentRequests}" varStatus="i">
            <tr>
                <td><c:out value="${requestDTO.request.name}"/></td>
                <td><c:out value="${requestDTO.userName}"/></td>
                <td><c:out value="${requestDTO.courseName}"/></td>
                <td><c:out value="${requestDTO.statusName}"/></td>
                <td>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="ADDING_STUDENT_TO_COURSE">
                        <input type="hidden" name="student_id" value="${requestDTO.request.userId}">
                        <input type="hidden" name="course_id" value="${requestDTO.request.courseId}">
                        <input type="hidden" name="request_id" value="${requestDTO.request.id}">
                        <input type="submit" value="${SUBMIT}">
                    </form>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="REJECT_REQUEST">
                        <input type="hidden" name="request_id" value="${requestDTO.request.id}">
                        <input type="submit" value="${REJECT}">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

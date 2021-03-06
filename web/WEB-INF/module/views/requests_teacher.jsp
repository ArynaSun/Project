<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_teacher_requests" class="table-responsive">
    <h3>${REQUESTS_TO_COMPLETE_COURSE}</h3>
    <table class="table table-striped table-sm">

        <thead>

        <tr>
            <th><c:out value="${STUDENT_NAME}"/></th>
            <th><c:out value="${COURSE_NAME}"/></th>
        </tr>

        </thead>
        <tbody>
        <%--@elvariable id="TeacherRequests" type="java.util.List"--%>
        <c:forEach var="requestDTO" items="${TeacherRequests}" varStatus="i">
            <tr>
                <td><c:out value="${requestDTO.userName}"/></td>
                <td><c:out value="${requestDTO.courseName}"/></td>
                <td>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="CHANGE_COURSE_STATUS">
                        <input type="hidden" name="course_status_id" value="3">
                        <input type="hidden" name="course_id" value="${requestDTO.request.courseId}">
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
        </tbody>
    </table>
</div>

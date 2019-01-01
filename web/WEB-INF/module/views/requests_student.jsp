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
            </tr>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="ADDING_STUDENT_TO_COURSE">
                <input type="hidden" name="student_name" value="${RequestDTO.userName}">
                <input type="hidden" name="course_name" value="${requestDTO.courseNamed}">
                <input type="submit" value="${SUBMIT}">
            </form>
        </c:forEach>
    </table>
</div>

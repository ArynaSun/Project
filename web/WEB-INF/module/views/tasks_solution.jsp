<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="_tasks">
    <h3>${TASKS}</h3>
    <table>
        <thead>
        <tr>
            <td><c:out value="${TASK_NAME}"/></td>
            <td><c:out value="${ASSIGNMENT_DATE}"/></td>
            <td><c:out value="${DEADLINE}"/></td>
            <td><c:out value="${SOLUTION}"/></td>
            <td><c:out value="${MARK}"/></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="taskDTO" items="${TaskSolutions}" varStatus="i">
            <tr>
                <td><c:out value="${taskDTO.task.name}"/></td>
                <td><c:out value="${taskDTO.task.assignmentDate}"/></td>
                <td><c:out value="${taskDTO.task.deadline}"/></td>
                <c:forEach var="solution" items="${taskDTO.solutions}" varStatus="i">
                    <c:if test="${solution.studentId == sessionScope.user.id}">
                        <td>
                                ${solution.answer}
                        </td>
                        <td>
                            <c:if test="${solution.accepted}">
                                ${solution.mark}
                            </c:if>
                        </td>
                    </c:if>
                </c:forEach>
                <c:if test="${fn:length(taskDTO.solutions) == 0}">
                    <td>
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="SEND_SOLUTION">
                            <input type="hidden" name="course_id" value="${Course.course.id}">
                            <input type="hidden" name="task_id" value="${taskDTO.task.id}">
                            <input type="hidden" name="student_id" value="${sessionScope.user.id}">
                            <label>${ANSWER}</label><br>
                            <input type="text" name="solution_answer"><br>
                            <input type="submit" value="${SUBMIT}">
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

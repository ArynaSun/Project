<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_tasks">
    <h3>${TASKS}</h3>
    <table>
        <td><c:out value="${TASK_NAME}"/></td>
        <td><c:out value="${ASIGNMENT_DATE}"/></td>
        <td><c:out value="${DEADLINE}"/></td>
        <%--@elvariable id="Tasks" type="java.util.List"--%>
        <c:forEach var="taskDTO" items="${TaskSolutions}" varStatus="i">
            <tr>
                <td><c:out value="${taskDTO.task.name}"/></td>
                <td><c:out value="${taskDTO.task.assignmentDate}"/></td>
                <td><c:out value="${taskDTO.task.deadline}"/></td>
            </tr>
            <tr>
                <td>${STUDENT_NAME}</td>
                <td>${ANSWER}</td>
                <td>${MARK}</td>
            </tr>
            <c:forEach var="solution" items="${taskDTO.solutions}" varStatus="i">
                <tr>
                    <td>${solution.studentId}</td>
                    <td>${solution.answer}</td>
                    <c:if test="${!solution.accepted}">
                        <td>
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="CHECK_SOLUTION">
                                <input type="hidden" name="course_id" value="${Course.course.id}">
                                <input type="hidden" name="solution_id" value="${solution.id}">
                                <label>${MARK}</label><br>
                                <input type="number" name="mark"><br>
                                <input type="submit" value="${SUBMIT}">
                            </form>
                        </td>
                    </c:if>

                    <c:if test="${solution.accepted}">
                        <td>
                            ${solution.mark}
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="_tasks" class="table-responsive">
    <h3>${TASKS}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th><c:out value="${TASK_NAME}"/></th>
            <th><c:out value="${ASSIGNMENT_DATE}"/></th>
            <th><c:out value="${DEADLINE}"/></th>
            <th><c:out value="${SOLUTION}"/></th>
            <th><c:out value="${MARK}"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="taskDTO" items="${TaskSolutions}" varStatus="i">
            <tr>
                <td><c:out value="${taskDTO.task.name}"/></td>
                <td><c:out value="${taskDTO.task.assignmentDate}"/></td>
                <td><c:out value="${taskDTO.task.deadline}"/></td>
                <c:forEach var="solutionDTO" items="${taskDTO.solutions}" varStatus="i">
                    <c:if test="${solutionDTO.solution.studentId == sessionScope.user.id}">
                        <td>
                                ${solutionDTO.solution.answer}
                        </td>
                        <td>
                            <c:if test="${solutionDTO.solution.accepted}">
                                ${solutionDTO.solution.mark}
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

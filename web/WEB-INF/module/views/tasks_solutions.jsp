<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_tasks" class="table-responsive">
    <h3>${TASKS}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th><c:out value="${TASK_NAME}"/></th>
            <th><c:out value="${ASSIGNMENT_DATE}"/></th>
            <th><c:out value="${DEADLINE}"/></th>
            <th>${STUDENT_NAME}</th>
            <th>${ANSWER}</th>
            <th>${MARK}</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="Tasks" type="java.util.List"--%>
        <c:forEach var="taskDTO" items="${TaskSolutions}" varStatus="i">
            <c:forEach var="solutionDTO" items="${taskDTO.solutions}">
                <tr>
                    <td><c:out value="${taskDTO.task.name}"/></td>
                    <td><c:out value="${taskDTO.task.assignmentDate}"/></td>
                    <td><c:out value="${taskDTO.task.deadline}"/></td>
                    <td>${solutionDTO.studentName}</td>
                    <td>${solutionDTO.solution.answer}</td>
                    <c:if test="${!solutionDTO.solution.accepted && sessionScope.user.id == Course.course.teacherId}">
                        <td>
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="CHECK_SOLUTION">
                                <input type="hidden" name="course_id" value="${Course.course.id}">
                                <input type="hidden" name="solution_id" value="${solutionDTO.solution.id}">
                                <input type="number" name="mark"><br>
                                <input type="submit" value="${SUBMIT}">
                            </form>
                        </td>
                    </c:if>
                    <c:if test="${solutionDTO.solution.accepted}">
                        <td>${solutionDTO.solution.mark}</td>
                    </c:if>
                </tr>
            </c:forEach>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_tasks">
    <h3>${TASKS}</h3>
    <table>
        <thead>
        <tr>
            <td><c:out value="${TASK_NAME}"/></td>
            <td><c:out value="${ASSIGNMENT_DATE}"/></td>
            <td><c:out value="${DEADLINE}"/></td>
            <td>${STUDENT_NAME}</td>
            <td>${ANSWER}</td>
            <td>${MARK}</td>
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
                </tr>
            </c:forEach>
        </c:forEach>
        </tbody>
    </table>
</div>
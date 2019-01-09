<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_tasks">
    <h3>${TASKS}</h3>
    <table>
        <thead>
        <tr>
            <td><c:out value="${TASK_NAME}"/></td>
            <td><c:out value="${ASSIGNMENT_DATE}"/></td>
            <td><c:out value="${DEADLINE}"/></td>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="TaskSolutions" type="java.util.List"--%>
        <c:forEach var="taskDTO" items="${TaskSolutions}" varStatus="i">
            <tr>
                <td><c:out value="${taskDTO.task.name}"/></td>
                <td><c:out value="${taskDTO.task.assignmentDate}"/></td>
                <td><c:out value="${taskDTO.task.deadline}"/></td>
            </tr>
        </c:forEach>
        </tbody>/
    </table>
</div>

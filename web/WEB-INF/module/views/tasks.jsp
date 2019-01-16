<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_tasks" class="table-responsive">
    <h3>${TASKS}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th><c:out value="${TASK_NAME}"/></th>
            <th><c:out value="${ASSIGNMENT_DATE}"/></th>
            <th><c:out value="${DEADLINE}"/></th>
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
        </tbody>
    </table>
</div>

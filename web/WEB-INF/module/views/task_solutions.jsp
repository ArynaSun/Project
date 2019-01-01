<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_task_solutions">
    <h3>${SOLUTIONS}</h3>
    <table>
        <%--@elvariable id="TaskSolutions" type="java.util.List"--%>
        <c:forEach var="taskDTO" items="${TaskSolutions}" varStatus="i">
            <tr>
                <td><c:out value="${taskDTO.task.name}"/></td>
                <td><c:out value="${taskDTO.courseName}"/></td>
                <td><c:out value="${taskDTO.task.attachmets}"/></td>
                <td><c:out value="${taskDTO.task.assignmentDate}"/></td>
                <td><c:out value="${taskDTO.task.deadline}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

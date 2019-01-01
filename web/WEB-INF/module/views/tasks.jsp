<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_tasks">
    <h3>${TASKS}</h3>
    <table>
        <%--@elvariable id="Tasks" type="java.util.List"--%>
        <c:forEach var="taskDTO" items="${Tasks}" varStatus="i">
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

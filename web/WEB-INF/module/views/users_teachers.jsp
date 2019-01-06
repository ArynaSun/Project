<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_teachers">
    <h3>${TEACHERS}</h3>
    <table>
        <td><c:out value="${TEACHER_NAME}"/></td>
        <td><c:out value="${E_MAIL}"/></td>
        <%--@elvariable id="Teachers" type="java.util.List"--%>
        <c:forEach var="teacher" items="${Teachers}" varStatus="i">
            <tr>
                <td><c:out value="${teacher.name}"/></td>
                <td><c:out value="${teacher.email}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

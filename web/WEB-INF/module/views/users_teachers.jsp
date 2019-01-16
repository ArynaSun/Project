<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_teachers" class="table-responsive">
    <h3>${TEACHERS}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th><c:out value="${TEACHER_NAME}"/></th>
            <th><c:out value="${E_MAIL}"/></th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="Teachers" type="java.util.List"--%>
        <c:forEach var="teacher" items="${Teachers}" varStatus="i">
            <tr>
                <td><c:out value="${teacher.name}"/></td>
                <td><c:out value="${teacher.email}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

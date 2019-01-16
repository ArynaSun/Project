<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_students" class="table-responsive">
    <h3>${STUDENTS}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th><c:out value="${STUDENT_NAME}"/></th>
            <th><c:out value="${STUDENT_EMAIL}"/></th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="Students" type="java.util.List"--%>
        <c:forEach var="student" items="${Students}" varStatus="i">
            <tr>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.email}"/></td>
                <c:if test="${sessionScope.user.roleId != 2}">
                    <td>
                        <a href="http://localhost:8080/controller?command=DISPLAY_STUDENT_INFO_PAGE&student_id=${student.id}">
                                ${DISPLAY}
                        </a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

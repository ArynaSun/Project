<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_students">
    <h3>${STUDENTS}</h3>
    <table>
        <%--@elvariable id="Students" type="java.util.List"--%>
        <c:forEach var="student" items="${Students}" varStatus="i">
            <tr>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.email}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_teachers">
    <h3>${TEACHERS}</h3>
    <table>
        <%--@elvariable id="Teachers" type="java.util.List"--%>
        <c:forEach var="teacher" items="${Teachers}" varStatus="i">
            <tr>
                <td><c:out value="${teacher.name}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

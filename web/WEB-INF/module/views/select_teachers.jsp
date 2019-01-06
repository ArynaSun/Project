<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id=_select_teachers">
    <select name="teacher_id">
        <c:forEach var="teacher" items="${Teachers}" varStatus="i">
            <option value="${teacher.id}">
                ${teacher.name}
            </option>
        </c:forEach>
    </select>
</div>

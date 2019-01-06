<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id=_select_students">
    <select name="student_id">
        <c:forEach var="student" items="${Students}" varStatus="i">
            <option value="${student.id}">
                    ${student.name}
            </option>
        </c:forEach>
    </select>
</div>

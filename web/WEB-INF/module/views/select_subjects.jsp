<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id=_select_subjects">
    <select name="subject_id">
        <c:forEach var="subject" items="${Subjects}" varStatus="i">
            <option value="${subject.id}">
                    ${subject.name}
            </option>
        </c:forEach>
    </select>
</div>

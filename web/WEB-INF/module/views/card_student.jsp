<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_student_info" class="table-responsive">
    <h3>${STUDENT}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th><c:out value="${STUDENT_NAME}"/></th>
            <th><c:out value="${STUDENT_EMAIL}"/></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><c:out value="${Student.name}"/></td>
            <td><c:out value="${Student.email}"/></td>
        </tr>
        </tbody>
    </table>
</div>

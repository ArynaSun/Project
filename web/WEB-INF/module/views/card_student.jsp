<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_student_info">
    <h3>${STUDENT}</h3>
    <table>
        <thead>
        <tr>
            <td><c:out value="${STUDENT_NAME}"/></td>
            <td><c:out value="${STUDENT_EMAIL}"/></td>
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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_student_info">
    <table>
        <tr>
            <td><c:out value="${Student.name}"/></td>
            <td><c:out value="${Student.email}"/></td>
        </tr>
    </table>
</div>

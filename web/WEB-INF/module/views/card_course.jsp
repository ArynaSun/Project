<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_course_info">
    <table>
        <%--@elvariable id="CompletedCourses" type="java.util.List"--%>
        <tr>
            <td><c:out value="${courseDTO.course.name}"/></td>
            <td><c:out value="${courseDTO.course.description}"/></td>
            <td><c:out value="${courseDTO.teacherName}"/></td>
            <td><c:out value="${courseDTO.subjectName}"/></td>
        </tr>
    </table>
</div>

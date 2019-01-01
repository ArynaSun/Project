<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_teacher_course">
    <h3>${COURSE_OF_TEACHER}</h3>
    <table>
        <tr>
            <td><c:out value="${CourseOfTeacher.course.name}"/></td>
            <td><c:out value="${CourseOfTeacher.course.description}"/></td>
            <td><c:out value="${CourseOfTeacher.teacherName}"/></td>
            <td><c:out value="${CourseOfTeacher.subjectName}"/></td>
        </tr>
    </table>
</div>

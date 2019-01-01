<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_student_reviews">
    <h3>${STUDENT_REVIEW}</h3>
    <table>
        <%--@elvariable id="CompletedCourses" type="java.util.List"--%>
        <c:forEach var="reviewDTO" items="${StudentReview}" varStatus="i">
            <tr>
                <td><c:out value="${reviewDTO.review.description}"/></td>
                <td><c:out value="${reviewDTO.review.mark}"/></td>
                <td><c:out value="${reviewDTO.studentName}"/></td>
                <td><c:out value="${reviewDTO.courseName}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="_student_reviews" class="table-responsive">
    <h3>${STUDENT_REVIEW}</h3>
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th><c:out value="${REVIEW_DESCRIPTION}"/></th>
            <th><c:out value="${MARK}"/></th>
            <th><c:out value="${STUDENT_NAME}"/></th>
            <th><c:out value="${COURSE_NAME}"/></th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="CompletedCourses" type="java.util.List"--%>
        <c:forEach var="reviewDTO" items="${StudentReview}" varStatus="i">
            <tr>
                <td><c:out value="${reviewDTO.review.description}"/></td>
                <td><c:out value="${reviewDTO.review.mark}"/></td>
                <td><c:out value="${reviewDTO.studentName}"/></td>
                <td><c:out value="${reviewDTO.courseName}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
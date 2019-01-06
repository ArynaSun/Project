<div id="_add_review">
    <h3>${ADD_REVIEW}</h3>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="ADDING_REVIEW_TO_STUDENT">
        <input type="hidden" name="course_id" value="${Course.course.id}">
        <jsp:include page="../views/select_students.jsp"/>
        <label>${MARK}</label><br>
        <input type="number" name="mark"><br>
        <label>${REVIEW_DESCRIPTION}</label><br>
        <input type="text" name="review_description"><br>
        <input type="submit" value="${SUBMIT}">
    </form>
</div>

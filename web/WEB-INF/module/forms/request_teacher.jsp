<div id="_request_teacher">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="COMPLETE_COURSE_REQUEST">
        <input type="hidden" name="course_id" value="${Course.course.id}">
        <input type="hidden" name="course_id" value="${sessionScope.user.id}">
        <input type="submit" value="${END_COURSE}">
    </form>
</div>

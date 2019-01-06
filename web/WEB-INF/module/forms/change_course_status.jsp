<div id="_change_course_status">
    <h3>${CHANGE_COURSE_STATUS}</h3>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="CHANGE_COURSE_STATUS">
        <input type="hidden" name="course_id" value="${Course.course.id}">
        <jsp:include page="../views/select_course_statuses.jsp"/>
        <input type="submit" value="${SUBMIT}">
    </form>
</div>

<div class="form send-request">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="REQUEST_TO_REGISTRATION">
        <input type="hidden" name="course_id" value="${courseDTO.course.id}">
        <input type="hidden" name="user_id" value="${sessionScope.user.id}">
        <input type="submit" value="${SEND_REQUEST}">
    </form>
</div>
<div id="_add_task">
    <h3>${ADD_TASK}</h3>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="ADDING_TASK_TO_COURSE">
        <input type="hidden" name="course_id" value="${Course.course.id}">
        <label>${TASK_NAME}</label><br>
        <input type="text" name="task_name"><br>
        <label>${DEADLINE}</label><br>
        <input type="date" name="task_deadline"><br>
        <input type="submit" value="${SUBMIT}">
    </form>
</div>

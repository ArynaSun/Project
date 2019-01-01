<div id="_add_course">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="ADDING_COURSE">
        <div>
            <label>${COURSE_NAME}</label><br>
            <input type="text" name="course_name"><br>
        </div>
        <div>
            <label>${COURSE_DESCRIPTION}</label><br>
            <input type="text" name="course_description"><br>
        </div>
        <div>
            <label>${TEACHER}</label><br>
            <input type="number" name="teacher_id"><br>
        </div>
        <div>
            <label>${SUBJECT}</label><br>
            <input type="number" name="subject_id"><br>
        </div>
        <input type="submit" value="${SUBMIT}"><br>
    </form>
</div>

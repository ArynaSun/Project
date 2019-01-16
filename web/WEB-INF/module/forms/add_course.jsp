<div id="_add_course">
    <h3>${ADD_COURSE}</h3>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="ADDING_COURSE">
        <div id="course_name">
            <label>${COURSE_NAME}</label><br>
            <input type="text" name="course_name"><br>
        </div>
        <div id="course_description">
            <label>${COURSE_DESCRIPTION}</label><br>
            <input type="text" name="course_description"><br>
        </div>
        <div id="select_subjects">
            <label>${SUBJECT}</label>
            <jsp:include page="../views/select_subjects.jsp"/>
        </div>
        <div id="select_teachers">
            <label>${TEACHER}</label>
            <jsp:include page="../views/select_teachers.jsp"/>
        </div>
        <input type="submit" value="${SUBMIT}"><br>
    </form>
</div>

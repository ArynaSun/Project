<div id="_add_teacher">
    <h3>${ADD_TEACHER}</h3>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="TEACHER_REGISTRATION">
        <div>
            <label>${TEACHER_NAME}</label><br>
            <input type="text" name="user_name"><br>
        </div>
        <div>
            <label>${E_MAIL}</label><br>
            <input type="text" name="email"><br>
        </div>
        <div>
            <label>${PASSWORD}</label><br>
            <input type="password" name="password"><br>
        </div>
        <input type="submit" value="${SIGN_UP}"/>
    </form>
</div>
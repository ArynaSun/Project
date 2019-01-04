
<div id="_registration">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="STUDENT_REGISTRATION">
        <div>
            <label>${NAME}</label>
            <div>
                <input type="text" name="name" placeholder="${NAME}">
            </div>
        </div>
        <div>
            <label>${E_MAIL}</label>
            <div>
                <input type="text" name="email" placeholder="${E_MAIL}"><br/>
            </div>
        </div>
        <div>
            <label>${PASSWORD}</label>
            <div>
                <input type="password" name="password" placeholder="${PASSWORD}"/>
            </div>
        </div>
        <input type="submit" value="${SIGN_UP}"/>
    </form>
</div>

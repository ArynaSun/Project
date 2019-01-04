
<div id="_login">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="login">
        <div>
            <label>${E_MAIL}</label>
            <div>
                <input type="text" name="email" placeholder="${E_MAIL}">
            </div>
        </div>
        <div>
            <label>${PASSWORD}</label>
            <div>
                <input type="password" name="password" placeholder="${PASSWORD}"/>
            </div>
        </div>
        <input type="submit" value="${SIGN_IN}"/>
    </form>
</div>
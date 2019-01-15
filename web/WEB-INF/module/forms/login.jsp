<div class="text-sm-left" id="_login">
    <form class="sign_in" action="controller" method="post">
        <input type="hidden" name="command" value="login">
        <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
             alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">${E_MAIL}</label>
        <input type="text" name="email" id="inputEmail" class="form-control" placeholder="${E_MAIL}" required autofocus>
        <label for="inputPassword" class="sr-only">${PASSWORD}</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="${PASSWORD}"
               required/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">${SIGN_IN}</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2018</p>
    </form>
</div>
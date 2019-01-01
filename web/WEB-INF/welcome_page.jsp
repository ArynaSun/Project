<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Добро пожаловать!</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="login">
    <div>
        <label>E-mail</label>
        <div>
            <input type="text" name="email" placeholder="e-mail">
        </div>
    </div>
    <div>
        <label>Password</label>
        <div>
            <input type="password" name="password" placeholder="password"/>
        </div>
    </div>
    <input type="submit" value="sign in"/>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="registration">
    <div>
        <label>Name</label>
        <div>
            <input type="text" name="name" placeholder="name">
        </div>
    </div>
    <div>
        <label>E-mail</label>
        <div>
            <input type="text" name="email" placeholder="e-mail"><br/>
        </div>
    </div>
    <div>
        <label>Password</label>
        <div>
            <input type="password" name="password" placeholder="password"/>
        </div>
    </div>
    <input type="submit" value="sign up"/>
</form>
</body>
</html>
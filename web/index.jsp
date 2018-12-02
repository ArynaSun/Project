<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
</head>
<body>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="login">
    <label>E-mail</label>
    <input type="text" name="email" placeholder="E-mail">
    <label>Password</label>
    <input type="password" name="password" placeholder="Password"/>
    <input type="submit" value="Sign in"/>
</form>
<br/>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="registration">
    <label>Name</label>
    <input type="text" name="name" placeholder="Name">
    <label>E-mail</label>
    <input type="text" name="email" placeholder="E-mail">
    <label>Password</label>
    <input type="password" name="password" placeholder="Password"/>
    <input type="submit" value="Sign up"/>
</form>
</body>
</html>
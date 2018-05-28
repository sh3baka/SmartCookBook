<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 25.05.2018
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WelcomeScreen</title>
</head>
<body>
<h1>Login Screen</h1>
<form action="validate" method="post">
    <input type="text" name="login" > Login <br>
    <input type="text" name="password" > Password <br>
    <input type="submit" value="Login" >
</form>
<a href="http://localhost:8080/SmartCookBook/registration">Registration</a>
</body>
</html>

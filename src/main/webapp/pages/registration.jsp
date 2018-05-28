<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 25.05.2018
  Time: 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registration</title>
</head>
<body>
<h1>Registration Screen</h1>
<form action="RegistrationController" method="POST">
    <input type="text" name="login" autocomplete="Login" > Login <br>
    <input type="text" name="password" autocomplete="Password" > Password <br>
    <input type="submit" value="Register User" >
</form>
</body>
</html>

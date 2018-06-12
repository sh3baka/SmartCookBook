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
    <style>
        a:link {
            color: black;
            text-decoration: none;
            background-color: white;
        }

        a:hover {
            color: black;
            text-decoration: none;
            background-color: aliceblue;
        }
    </style>
</head>
<body>
<h1>Login Screen</h1>
<form action="validate" method="post">
    <table>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td align="right" colspan="2"><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>
<a href="http://localhost:8080/SmartCookBook/registration">Registration</a>
</body>
</html>



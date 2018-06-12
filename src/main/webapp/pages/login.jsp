<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 11.05.2018
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Menu</title>
    <style>
        table, tr, td {
            color: brown;
            background-color: orange;
        }

        a:link {
            color: black;
            text-decoration: none;
            background-color: orange;
        }

        a:hover {
            color: white;
            text-decoration: none;
            background-color: orangered;
        }
    </style>
</head>
<body>
<%--<h3>Здравствуйте ${userModel.username} <br></h3>--%>
<table>
    <tr>
        <td align="center"><h4>Меню</h4></td>
    </tr>
    <tr>
        <td align="left"><a href="http://localhost:8080/SmartCookBook/recipes">Посмотреть доступные Рецепты</a></td>
    </tr>
    <tr>
        <td align="left"><a href="http://localhost:8080/SmartCookBook/fridge">Внести изменения в холодильник</a></td>
    </tr>
</table>
</body>
</html>
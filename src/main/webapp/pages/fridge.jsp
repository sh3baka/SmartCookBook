<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 29.05.2018
  Time: 3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Fridge</title>
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
<table>
    <tr>
        <td align="center"><h4>Меню</h4></td>
    </tr>
    <tr>
        <td align="left"><a href="http://localhost:8080/SmartCookBook/recipes">Посмотреть доступные Рецепты</a></td>
    </tr>
</table>
<form action="getfridge" method="post">
    <c:forEach var="fridge" items="${fridgeModel}">


        <br><input type="checkbox" name="products" value="${fridge.getTitle()}">${fridge.getTitle()}

    </c:forEach>
    <br><input type="submit" value="Сохранить Изменения">
</form>
</body>
</html>

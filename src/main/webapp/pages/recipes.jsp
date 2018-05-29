<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 28.05.2018
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Recipes</title>
    <style>
        table, tr, td {
            color: brown ;
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
        h2 {
            color: darkblue;
        }
    </style>
</head>
<table>
    <tr>
        <td align="center"><h4>Меню</h4></td>
    </tr>
    <tr>
        <td align="left"><a href="http://localhost:8080/SmartCookBook/fridge">Внести изменения в холодильник</a></td>
    </tr>
</table>

<h1>Рецепты вы можете приготовить:</h1>
<c:forEach var="recipes" items="${recipeModel}">
    <h2>${recipes.getTitle()}<br></h2>
    <h4>${recipes.getDesc()}<br><br></h4>
</c:forEach>
</body>
</html>

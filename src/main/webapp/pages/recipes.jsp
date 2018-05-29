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
</head>
<h1>Рецепты вы можете приготовить:</h1>



<c:forEach var="recipes" items="${recipeModel}">
    <h3>${recipes.getTitle()}<br></h3>
    <h4>${recipes.getDesc()}<br><br></h4>
</c:forEach>
</body>
</html>

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
</head>
<body>
<form action="getfridge" method="post">

    <c:forEach var="fridge" items="${fridgeModel}">

        <input type="checkbox" name="products" value="${fridge.getTitle()}">${fridge.getTitle()}

    </c:forEach>
    <input type="submit" value="Submit">
</form>
</body>
</html>

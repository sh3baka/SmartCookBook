<%--
  Created by IntelliJ IDEA.
  User: Костя
  Date: 28.05.2018
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>errorPage</title>
    <style>
        h4 {
            color: red;
        }
    </style>
</head>
<body>
<h1>Error page:</h1>
<c:forEach var="error" items="${errorModel}">
    <h3>${error.getField()}<br></h3>
    <h4>${error.getErrorMsg()}<br><br></h4>
</c:forEach>
</body>
</html>

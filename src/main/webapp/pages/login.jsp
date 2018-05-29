
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
    <title>JSP page</title>
</head>
<body>

<h3>Welcome ${userModel.username} <br></h3>
<a href="http://localhost:8080/SmartCookBook/recipes">Show Recipes</a>
<a href="http://localhost:8080/SmartCookBook/fridge">Show Fridge</a>


<%--<% User user =  %>--%>
<%--<h1> <%user.getUsername();%> </h1>--%>
<%--<h2> <%user.getPassword();%> </h2>--%>




</body>
</html>

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
<%!int i;%>
<%for (i = 0; i < 10; i++){%>
<h1>Hello ${userModel.username} <br></h1>
<h3>Welcome ${currentUser.username} <br></h3>
<%}%>

<%--<% User user =  %>--%>
<%--<h1> <%user.getUsername();%> </h1>--%>
<%--<h2> <%user.getPassword();%> </h2>--%>




</body>
</html>
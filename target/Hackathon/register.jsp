<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 23/01/2018
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.academiadecodigo.bootcamp.Controllers.LoginController" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>

<p>Welcome to this app. Insert your user name</p>
</br>

<!-- Put the name and password -->
<form method="post" action="Register">
    <p>username: <input type="text" name="username"/></p>
    <p>email: <input type="text" name="email"/></p>
    <p>password:<input type="password" name="password"/></p>
    <p><input type="submit" value="Register"/></p>
</form>

<!-- Condition to make the message appears when the login is not right -->
<c:out value="${message}" default="Value not specified." />
<!-- -->
<h2>${message}</h2>

</body>
</html>

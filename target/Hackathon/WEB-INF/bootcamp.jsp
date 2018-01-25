<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 23/01/2018
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bootcamps List</title>


</head>
<body>

<h2>Welcome ${name}</h2>
<h2>List of all bootcamps</h2>

<br/>
<form  method="get">
    <button type="submit" id="list" name="list">${buttonName}</button>
</form>
<br/>

<!-- Bootcamps Table -->
<ul>
    <c:forEach var="bootcamp" items="${bootcamps}">
        <li>${bootcamp.name} <strong>${bootcamp.id}</strong> <strong>${bootcamp.place}</strong></li>
    </c:forEach>
</ul>
<!-- Users Table -->
<ul>
    <c:forEach var="user" items="${usersList}">
        <li>${user.name} <strong>${user.password}</strong> </li>
    </c:forEach>
</ul>



</body>
</html>

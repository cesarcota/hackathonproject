<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 26/01/2018
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="dashboard" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Cheapsters</h2>

    <ul>
        <c:forEach var="group" items="${userGroup}">
            <li>${group.groupName} </li>
        </c:forEach>
    </ul>

    <a href="groupStats" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Users</a>

    <table class="table table-hover">
        <thead>
        <tr>
            <th>Group Name</th>
            <th>Category</th>
            <th></th>
            <th></th>

        </tr>
        <tr>
            <td>Airados</td>
            <td>Beer</td>

        </tr>
        <tr>
            <td>Queimados</td>
            <td>Coffee</td>

        </tr>
        </thead>
        <tbody>

        <tbody>


    </tbody>
    </table>

</div>

</body>
</html>
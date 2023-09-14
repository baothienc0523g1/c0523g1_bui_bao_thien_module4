<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/14/2023
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    h1 {
        text-align: center;
    }
    table {
        border: 1px solid black;
        text-align: center;
    }
</style>
<body>
<h1>Customer List</h1>
<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>EMAILL</td>
        <td>ADDRESS</td>
    </tr>
    <c:forEach var="li" items="${list}">
        <tr>
            <td>${li.id}</td>
            <td>${li.name}</td>
            <td>${li.email}</td>
            <td>${li.address}</td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>

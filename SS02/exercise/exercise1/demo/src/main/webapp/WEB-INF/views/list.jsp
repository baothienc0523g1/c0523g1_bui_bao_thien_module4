<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/15/2023
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Ứng dụng hiển thị gia vị với Sandwich</h3>
<c:forEach var="li" items="${list}" varStatus="loop">
    <p>${loop.count}</p>
    <p>${li.toString()}</p>
    <button><a href="/save/back">Back to form</a></button>
</c:forEach>
</body>
</html>

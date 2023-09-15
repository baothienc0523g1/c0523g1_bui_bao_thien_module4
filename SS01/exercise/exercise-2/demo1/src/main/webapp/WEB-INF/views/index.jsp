<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/14/2023
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Vocabulary</h1>
<table>
    <table>
        <c:forEach var="v" items="${vocabulary}">
            <tr>
                <td>
                        ${v.key}
                </td>
                <td>
                        ${v.value}
                </td>
            </tr>
        </c:forEach>
    </table>
</table>
<form action="" method="post">
    <table>
        <tr>
            <td><label for="keyWord">Enter keyword</label></td>
            <td><input type="text" name="keyWord" id="keyWord" value="${keyWord}"></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">OK</button></td>
        </tr>
        <tr>
            <td colspan="2">${result}${invalid}</td>
        </tr>
    </table>
</form>
</body>
</html>

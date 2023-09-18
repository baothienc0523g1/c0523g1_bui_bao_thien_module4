<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/18/2023
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table {
        border: 1px solid black;
        border-radius: 9px;
        margin: 15% auto auto auto;
    }

    button {
        height: auto;
        border-radius: 5px;
        background-color: deepskyblue;
        color: #fff;
    }

    a {
        text-decoration: none;
    }
</style>
<body>
<table>
    <tr>
        <td>
            Languages:
        </td>
        <td>
            ${mailConfigs.language}
        </td>
    </tr>
    <tr>
        <td>
            Page size:
        </td>
        <td>
            ${mailConfigs.pageSize} items per page
        </td>
    </tr>
    <tr>
        <td>
            Spam:
        </td>
        <td>
            <c:if test="${mailConfigs.spam == true}">
                Yes
            </c:if>
            <c:if test="${mailConfigs.spam == false}">
                No
            </c:if>
        </td>
    </tr>
    <tr>
        <td>
            Signature:
        </td>
        <td>
            ${mailConfigs.signature}
        </td>
    </tr>
    <tr>
        <td>
            <button><a href="/">Show config editor</a></button>
        </td>
    </tr>
</table>
</body>
</html>

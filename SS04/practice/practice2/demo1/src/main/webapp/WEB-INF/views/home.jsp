<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/15/2023
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>HOME</h3>
<form:form action="login" method="post" modelAttribute="login">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td>
                    <form:label path="account">Account: </form:label>
                </td>
                <td>
                    <form:input path="account"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Pass word</form:label>
                </td>
                <td>
                    <form:input path="password"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:button>Login</form:button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>

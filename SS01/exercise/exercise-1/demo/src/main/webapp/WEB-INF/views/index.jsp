<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/14/2023
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert</title>
</head>
<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }
    .header {
        height: 76px;
        width: 100%;
        background-color: #272882;
    }
    table {
        margin-right: auto;
        margin-left: auto;
        margin-top: 8%;
    }
</style>
<body>
<div class="header">
</div>
<form method="post" action="do-convert">
    <table>
        <tr>
            <td><label for="usd">Enter USD</label></td>
            <td><input type="number" name="usd" id="usd"></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">submit</button></td>
        </tr>
        <tr>
            <td colspan="2">${result}${VND}</td>
        </tr>
    </table>
</form>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculating" method="post">
    <table>
        <tr>
            <td colspan="2"><input type="number" width="350px" name="firstOperator" placeholder="Enter first operator"
                                   value="${firstOperator}"></td>
            <td colspan="2"><input type="number" width="350px" name="secondOperator" placeholder="Enter second operator"
                                   value="${secondOperator}"></td>
        </tr>
        <tr>
            <td>
                <button type="button" onclick="getAction(1)">Addition (+)</button>
            </td>
            <td>
                <button type="button" onclick="getAction(2)">Subtraction (-)</button>
            </td>
            <td>
                <button type="button" onclick="getAction(3)">Multiplication (*)</button>
            </td>
            <td>
                <button type="button" onclick="getAction(4)">Division (/)</button>
            </td>
        </tr>
        <tr>
            <td colspan="4">${notice}</td>
        </tr>
        <tr>
            <td colspan="4">${result}</td>
        </tr>
        <tr>
            <td colspan="2"><input type="number" id="submitNumber" name="submitNumber" style="display: none"></td>
            <td colspan="2">
                <button type="submit" id="submitBtn" style="display: none"></button>
            </td>
        </tr>
    </table>
</form>
<script>
    function getAction(number) {
        switch (number) {
            case 1:
                document.getElementById("submitNumber").value = 1;
                break;
            case 2:
                document.getElementById("submitNumber").value = 2;
                break;
            case 3:
                document.getElementById("submitNumber").value = 3;
                break;
            case 4:
                document.getElementById("submitNumber").value = 4;
                break;
        }
        document.getElementById("submitBtn").click();
    }
</script>
</body>
</html>
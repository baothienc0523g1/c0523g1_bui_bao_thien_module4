<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Email Configuration</title>
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
    }

    #cancel {
        margin-right: 4%;
    }

    #submit {
        background-color: deepskyblue;
        color: #fff;
    }

    a {
        text-decoration: none;
    }
</style>
<body>
<table>
    <form:form modelAttribute="mailConfig" method="post" action="/save">
        <tr>
            <td colspan="2"><strong>Settings</strong></td>
        </tr>
        <tr>
            <th>Languages</th>
            <td>
                <form:select path="language">
                    <form:options items="${language}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Page Size</th>
            <td>
       <span>Show
           <form:select path="pageSize">
               <form:options items="${sizes}"/>
           </form:select>
         emails per page
       </span>
            </td>
        </tr>
        <tr>
            <th>Spams filter:</th>
            <td>
                <form:checkbox path="spam"/>
            </td>
        </tr>
        <tr>
            <th>Signature:</th>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
                <button id="submit" type="submit">Update</button>
                <button id="cancel" type="reset">Cancel</button>
            </td>
        </tr>
    </form:form>
    <tr>
        <td>
            <button><a href="show-config">Show config</a></button>
        </td>
    </tr>
</table>
</body>
</html>
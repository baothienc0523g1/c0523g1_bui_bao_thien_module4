<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Customer List</title>
</head>
<style>
  * {
    margin: 0;
    padding: 0;
  }
  h2 {
    text-align: center;
    margin-top: 20px;
    margin-bottom: 20px;
  }
   tr td {
    border: 1px solid blue;
    border-collapse: collapse;
  }
  table {
    margin-right: auto;
    margin-left: auto;
  }
  header {
    height: 76px;
    width: 100%;
    background-color: blue;
  }
</style>
<body>
<header></header>
<h2>Customer List</h2>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Adress</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="c" items="${customerList}">
    <tr>
      <td>${c.id}</td>
      <td><a href="/customers/${c.id}">${c.name}</a></td>
      <td>${c.email}</td>
      <td>${c.address}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
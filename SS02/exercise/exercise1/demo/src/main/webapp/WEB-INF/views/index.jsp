<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bài tập 1</title>
</head>
<style>
    h3 {
        text-align: center;
    }
    table {
      margin-right: auto;
      margin-left: auto;
      margin-top: 10rem;
      border-collapse: collapse;
    }
    tr td {
      border: 1px solid blue;
    }
</style>
<body>
<h3>Ứng dụng hiển thị gia vị với Sandwich</h3>

<form action="/save" method="post">
    <table>
        <tr>
          <td>
            <input type="checkbox" name="condiment" id="lettuce" value="Lettuce">
          </td>
          <td>
            <label for="lettuce">Lettuce</label>
          </td>
        </tr>
      <tr>
        <td>
          <input type="checkbox" name="condiment" id="tomato" value="Tomato">
        </td>
        <td>
          <label for="tomato">Tomato</label>
        </td>
      </tr>
      <tr>
        <td>
          <input type="checkbox" name="condiment" id="mustard" value="Mustard">
        </td>
        <td>
          <label for="mustard">Mustard</label>
        </td>
      </tr>
      <tr>
        <td>
          <input type="checkbox" name="condiment" id="sprouts" value="sprouts">
        </td>
        <td>
          <label for="sprouts">sprouts</label>
        </td>
      </tr>
      <tr>
        <td colspan="2"><button type="submit">OK</button></td>
      </tr>
    </table>
</form>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: win
  Date: 10/26/2021
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Caculator</h2>
<form method="post" action="/calculator">
    <table>
        <tr>
            <td colspan="2">
                <input type="number" name="first" value="${first}" required>
            </td>
            <td colspan="2">
                <input type="number" name="second" value="${second}" required>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="calculate" value="Addition(+)">
            </td>
            <td>
                <input type="submit" name="calculate" value="Subtraction(-)">
            </td>
            <td>
                <input type="submit" name="calculate" value="Multiplication(X)">
            </td>
            <td>
                <input type="submit" name="calculate" value="Division(/)">
            </td>
        </tr>
    </table>
    <h3>${result}</h3>
</form>
</body>
</html>

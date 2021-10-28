<%--
  Created by IntelliJ IDEA.
  User: win
  Date: 10/27/2021
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="email1" type="com.codegym"--%>
<form:form method="post" action="/update" modelAttribute="email1">
    <table>
        <tr>
            <th>language</th>
            <td><form:select path="language" items="${languages}"/></td>
        </tr>

        <tr>
            <th>Page Size:</th>
            <td>Show <form:select path="size" items="${pageSize}"/> emails per page</td>
        </tr>

        <tr>
            <th>Spam Filter:</th>
            <form:checkbox path="filter"/>
        </tr>

        <tr>
            <th>Signature</th>
            <td><form:textarea path="signature"/></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

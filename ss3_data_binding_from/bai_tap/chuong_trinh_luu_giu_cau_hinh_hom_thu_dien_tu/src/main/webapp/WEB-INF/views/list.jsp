<%--
  Created by IntelliJ IDEA.
  User: win
  Date: 10/27/2021
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Language</td>
        <td>${email.language}</td>
    </tr>
    <tr>
        <td>Page Sire</td>
        <td>${email.size}</td>
    </tr>
    <tr>
        <td>Spam Filter</td>
        <c:if test="${email.filter == true}">
            <td>Enable spam filter</td>
        </c:if>
        <c:if test="${email.filter == false}">
            <td></td>
        </c:if>
    </tr>
    <tr>
        <td>Signature: </td>
        <td> ${email.signature}</td>
    </tr>
</table>
</body>
</html>

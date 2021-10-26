<%--
  Created by IntelliJ IDEA.
  User: win
  Date: 10/26/2021
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<form action="/save" >
    <c:if test='${condiment != null}'>
        <span >Your sandwich with condiment: </span>
        <c:forEach var="sandwich" items="${condiment}">
            <>${sandwich}</span>
        </c:forEach>
    </c:if>
    <div>
        <input type="checkbox" name="condiment"  value="Lettuce">
        <input type="checkbox" name="condiment"  value="Tomato">
        <input type="checkbox" name="condiment"  value="Mustard">
        <input type="checkbox" name="condiment"  value="Sprouts">
    </div>
    <div>
        <button type="submit">Save</button>
    </div>
</form>
</body>
</html>

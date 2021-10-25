<%--
  Created by IntelliJ IDEA.
  User: win
  Date: 10/24/2021
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Money Converter</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body><h1>USD to VNĐ</h1>
<form class="form-control" action="convert" method="post">
  <input name="usd" type="number" />
  <input type="submit" value="convert" />
</form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/15/2021
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="../static/bootstrap-4.3.1-dist/css/bootstrap.min.css">
</head>
<body>
div class="row">
<div class="col-8">
    <h1>Search customer by <c:out value="${search}"></c:out></h1>
</div>
<div class="col-4">
    <div>
        <p class="navbar-text" style="float:right">Welcome ${sessionScope.user.employeeName}</p>
    </div>
</div>
</div>
<c:if test="${empty customerList}">
    <h3 style="color: red">No results were found</h3>
    <h3>
        <a href="/customer">Back to list all customers</a>
    </h3>
</c:if>
<c:if test="${not empty customerList}">
    <h3>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </h3>
    <h3>
        <a href="/customer">Back to list all customers</a>
    </h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Id card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Customer type</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope['customerList']}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>
                    <c:choose>
                        <c:when test="${customer.gender == 1}">Nam</c:when>
                        <c:when test="${customer.gender == 2}">Nữ</c:when>
                        <c:otherwise>LGBT</c:otherwise>
                    </c:choose>
                </td>
                <td>${customer.idCard}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <c:choose>
                        <c:when test="${customer.customerTypeId == 1}">Diamond</c:when>
                        <c:when test="${customer.customerTypeId == 2}">Platinium</c:when>
                        <c:when test="${customer.customerTypeId == 3}">Gold</c:when>
                        <c:when test="${customer.customerTypeId == 4}">Silver</c:when>
                        <c:when test="${customer.customerTypeId == 5}">Member</c:when>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="../static/bootstrap-4.3.1-dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/16/2021
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <title>Employee Management</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="../static/bootstrap-4.3.1-dist/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-8">
        <h1>Search employee by <c:out value="${search}"></c:out></h1>
    </div>

</div>
<c:if test="${empty employeeList}">
    <h3>
        <a href="/employee">Back to list all employees</a>
    </h3>
</c:if>
<c:if test="${not empty employeeList}">
    <h3>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </h3>
    <h3>
        <a href="/employee">Back to list all employees</a>
    </h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Id Card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>Education Degree</th>
            <th>Division</th>
            <th>Username</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${requestScope['employeeList']}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.birthday}</td>
                <td>${employee.idCard}</td>
                <td>${employee.salary}</td>
                <td>${employee.phone}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>
                    <c:choose>
                        <c:when test="${employee.positionId == 1}">L??? t??n</c:when>
                        <c:when test="${employee.positionId == 2}">Ph???c v???</c:when>
                        <c:when test="${employee.positionId == 3}">Chuy??n vi??n</c:when>
                        <c:when test="${employee.positionId == 4}">Gi??m s??t</c:when>
                        <c:when test="${employee.positionId == 5}">Qu???n l??</c:when>
                        <c:when test="${employee.positionId == 6}">Gi??m ?????c</c:when>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${employee.educationDegreeId == 1}">Trung c???p</c:when>
                        <c:when test="${employee.educationDegreeId == 2}">Cao ?????ng</c:when>
                        <c:when test="${employee.educationDegreeId == 3}">?????i h???c</c:when>
                        <c:when test="${employee.educationDegreeId == 4}">Sau ?????i h???c</c:when>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${employee.divisionId == 1}">Sale - Marketing</c:when>
                        <c:when test="${employee.divisionId == 2}">H??nh ch??nh</c:when>
                        <c:when test="${employee.divisionId == 3}">Ph???c v???</c:when>
                        <c:when test="${employee.divisionId == 4}">Qu???n l??</c:when>
                    </c:choose>
                </td>
                <td>${employee.username}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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

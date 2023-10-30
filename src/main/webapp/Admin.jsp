<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hathanhtinh
  Date: 30/10/2023
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">List User</h1>
<form>
    <div class="container">
    <table class="table table-bordered border-primary">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th style="width: 300px">PhoneNumber</th>
        </tr>

        <c:forEach var="admin" items="${list}">
            <tr>
                <td>${admin.id}</td>
                <td>${admin.name}</td>
                <td>${admin.email}</td>
                <td>${admin.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
</form>
</body>
</html>



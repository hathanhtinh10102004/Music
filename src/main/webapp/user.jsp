<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hathanhtinh
  Date: 22/11/2023
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show User</title>
    <style>
        body {
            background-image: url("https://bloghocpiano.com/wp-content/uploads/2021/03/572353.jpg");
            background-size: cover;
        }

        .list-user {
            text-align: center;
            color: white;
            margin-top: 55px;
        }

        .button-delete {
            color: red;
        }
    </style>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>

<body>
<div class="header">
    <h1 class="list-user">List User</h1>
</div>
<form action="admin" method="get">
    <input type="hidden" value="${user.getEmail()}" name="email"/>
    <input type="hidden" value="${user.getPassWord()}" name="password"/>
    <button name="action" value="back" style="border: none"> <- Back</button>
</form>

<form>
    <div class="container">
        <table style="color: white" class="table table-bordered border-primary">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>PhoneNumber</th>
            </tr>
            <c:forEach var="admin" items="${listUser}">
                <tr>
                    <td>${admin.id}</td>
                    <td>${admin.name}</td>
                    <td>${admin.email}</td>
                    <td>${admin.phoneNumber}</td>
                    <form action="admin" method="get">
                        <input type="hidden" value="${admin.id}" name="id"/>
                        <input type="hidden" value="${user.getEmail()}" name="email"/>
                        <input type="hidden" value="${user.getPassWord()}" name="password"/>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>

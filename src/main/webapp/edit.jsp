<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hathanhtinh
  Date: 31/10/2023
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
    <style>
        body{
            background-image: url("https://images.pexels.com/photos/3721941/pexels-photo-3721941.jpeg?cs=srgb&dl=pexels-daniel-reche-3721941.jpg&fm=jpg");
            background-size: cover;
        }
        .update-form {
            max-width: 400px;
            margin: 180px auto;
        }

        .form-group {
            margin-bottom: 10px;
            color: white;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
        }
        h1 {
            color: white;
        }
        .a {
            width:100px;
            height:35px;
            margin-left: 115%;
        }


    </style>
</head>
<body>
<div class="update-form">
    <h1 style="text-align: center; margin-top: 20px" >Update Data</h1>
    <form action="/user" method="post">
        <c:forEach var="list" items="${list}">
            <div class="form-group">
                <input type="hidden" name="id" value="${list.id}">
                <label for="name">Name:</label>
                <input style="background-color: #fff; height: 40px; width: 500px" type="text" id="name" name="name" value="${list.name}" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input style="background-color: #fff; height: 40px; width: 500px" type="text" id="email" name="email" value="${list.email}" required>
            </div>
            <div class="form-group">
                <label for="email">Phone:</label>
                <input style="background-color: #fff; height: 40px; width: 500px" type="text" id="phone" name="phoneNumber" value="${list.phoneNumber}" required>
                <input type="hidden" name="password" value="${list.passWord}" />
            </div>
            <div style="margin-right: 50px">
            <button class="a" style="background-color: #41b041"  name="action" value="edit">Update</button>
            </div>
        </c:forEach>
    </form>
</div>
</body>
</html>

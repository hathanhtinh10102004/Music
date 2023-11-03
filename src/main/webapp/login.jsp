<%--
  Created by IntelliJ IDEA.
  User: hathanhtinh
  Date: 30/10/2023
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style>
        body {
            background-image: url("https://morninglightmusic.io/wp-content/uploads/2022/11/Hero-Image-V2-1.jpg");
            background-size: contain;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;

        }

        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 40px;
            /*background-color: #fff;*/
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 180px auto;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 20px;
            color: white;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 3px;
            border: 1px solid #ccc;
            /*color: #fff;*/
        }

        input[type="submit"] {
            width: 25%;
            padding: 10px;
            font-size: 16px;
            background-color: #007bff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            margin-left: 75%;
        }

        input[type="submit"]:hover {
            background-color: #0069d9;
        }
        h1 {
            color: white;
        }
        .register-link {
            margin-top: -30px;
            margin-right: 20px;
            color: white;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Music</h1>
    <form action="/user?action=login" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <p style="color: red">${message}</p>
        <input type="submit" value="Login">
        <a class="register-link" href="register.jsp">Đăng Ký</a>
    </form>
</div>
</body>
</html>



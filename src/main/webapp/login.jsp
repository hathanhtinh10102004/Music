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
            background-image: url("https://i.ytimg.com/vi/uk8nTOk6D3w/maxresdefault.jpg");
            background-size: contain;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;

        }

        .container {
            max-width: 400px;
            padding: 40px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 180px auto;
            margin-top: 21%;
        }

        h1 {
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
            color: white;
        }

        input[type="submit"]:hover {
            background-color: #0069d9;
        }

        h1 {
            color: white;
        }


        .register-button {
            width: 26%;
            font-size: 16px;
            margin-top: -53px;
            margin-right: 20px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 3px;
            padding: 10px;
            cursor: pointer;
        }

        .register-button:hover {
            background-color: #0069d9;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Login </h1>
    <form action="user?action=login" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <p style="color: red">${message}</p>
        <input type="submit" value="Login">
        <%--        <a class="register-link" href="register.jsp">Register</a>--%>
    </form>
    <button class="register-button" onclick="goToHome()">Register</button>


</div>
<script>
    function goToHome() {
        window.location.href = "register.jsp"; // Replace "/home" with the actual URL of your home page
    }
</script>
</body>
</html>



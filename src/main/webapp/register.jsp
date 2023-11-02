<%--
  Created by IntelliJ IDEA.
  User: vu
  Date: 31/10/2023
  Time: 08:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register account</title>
</head>
<body>
<h1 style="text-align: center">Register account</h1>
<div style="width: 200px; margin-left: auto; margin-right: auto;">
<form action="/register" method="post">
    Name: <input type="text" name="name">
    Email: <input type="text" name="email">
    Phone number: <input type="number" name="phoneNumber">
    Password: <input type="text" name="passWord">
  <input type="hidden" name="action" value="register">
    <input type="submit" value="Register">
</form>
</div>
</body>
</html>

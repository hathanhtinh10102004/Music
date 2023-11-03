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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-image:url('https://img5.thuthuatphanmem.vn/uploads/2021/11/17/anh-nen-am-nhac-2k-dep_013828747.jpg'); background-size: contain" >
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1 class="text-center">Register Account</h1>
        </div>
        <div class="panel-body">
            <form method="post">
                <div class="form-group">
                    <label for="usr">Name:</label>
                    <input required="true" type="text" class="form-control" id="usr" name="name"/>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input required="true" type="email" class="form-control" id="email" name="email"/>
                </div>
                <div class="form-group">
                    <label for="Phone number">Phone number:</label>
                    <input type="number" class="form-control" id="Phone number" name="Phone number"/>
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input required="true" type="password" class="form-control" id="pwd" name="password"/>
                </div>
                <div style="text-align: center">
                    <button class="btn btn-success">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--<h1 style="text-align: center">Register account</h1>--%>
<%--<div style="width: 200px; margin-left: auto; margin-right: auto;">--%>
<%--<form action="/register" method="post">--%>
<%--    Name: <input type="text" name="name">--%>
<%--    Email: <input type="text" name="email">--%>
<%--    Phone number: <input type="number" name="phoneNumber">--%>
<%--    Password: <input type="text" name="passWord">--%>
<%--  <input type="hidden" name="action" value="register">--%>
<%--    <input type="submit" value="Register">--%>
<%--</form>--%>
<%--</div>--%>
</body>
</html>



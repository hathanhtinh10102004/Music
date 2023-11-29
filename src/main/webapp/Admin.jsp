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
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    #wrapper {
        width: auto;
        margin: auto;
    }

    #header {
        width: 1848px;
        height: 100px;
        background-color: #1f1f1f;
    }
    menu {
        width: 1848px;
        height: 70px;
        background-color: #171b25;
    }


    #left {
        width: 20%;
        height: 704px;
        background-color: #030715;
        float: left;
    }

    #content {
        width: 60%;
        height: 704px;
        background-color: #030715;
        float: left;
    }

    #right {
        width: 20%;
        height: 704px;
        background-color: #030715;
        float: left;
    }

    #footer {
        width: 1848px;
        height: 70px;
        background-color: #18191e;
        clear: both;
        padding: 15px
    }
</style>

<head>
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

        .confirmation-dialog {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            z-index: 9999;
        }
    </style>
    <title>Show Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="header">
    <h1 class="list-user">User</h1>
</div>
<form action="admin" method="get">
    <input type="hidden" value="${user.getEmail()}" name="email"/>
    <input type="hidden" value="${user.getPassWord()}" name="password"/>
</form>
<form action="addUser.jsp?email=${user.getEmail()}&password=${user.getPassWord()}" >
    <button name="action" value="add">Add</button>
</form>
<form action="/admin" method="get">
    <input type="hidden" value="${user.getEmail()}" name="email"/>
    <input type="hidden" value="${user.getPassWord()}" name="password"/>
    <button name="action" value="back" style="border: none"> <- Back</button>
</form>

    <div class="container">
        <table style="color: white" class="table table-bordered border-primary">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>PhoneNumber</th>
                <th>Action</th>
            </tr>

            <c:forEach var="admin" items="${listUser}">
                <tr>
                    <td>${admin.id}</td>
                    <td>${admin.name}</td>
                    <td>${admin.email}</td>
                    <td>${admin.phoneNumber}</td>
                    <td>
                        <form action="admin" method="get">
                            <input type="hidden" value="${admin.id}" name="id"/>
                            <input type="hidden" value="${user.getEmail()}" name="email"/>
                            <input type="hidden" value="${user.getPassWord()}" name="password"/>
                            <div id="confirmationDialog" class="confirmation-dialog">
                                <p style="color: red">Do you want to update?</p>
                                <button name="action" value="delete" onclick="confirmUpdate()">OK</button>
                                <button onclick="cancelUpdate()">Cancel</button>
                            </div>
                        </form>
                        <button onclick="showConfirmation()" class="button-delete" name="action" value="delete">Delete</button>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${not empty add}">
                <script>
                    alert("${add}")
                </script>
            </c:if>
        </table>
    </div>
<script>
    function showConfirmation() {
        var confirmationDialog = document.getElementById('confirmationDialog');
        confirmationDialog.style.display = 'block';
        return false; // Prevent the form from submitting
    }

    function confirmUpdate() {
        document.forms[0].submit();
        var confirmationDialog = document.getElementById('confirmationDialog');
        confirmationDialog.style.display = 'none';
        alert("Xoá thành công");
        window.location.href = "songList.jsp";

    }

    function cancelUpdate() {
        var confirmationDialog = document.getElementById('confirmationDialog');
        confirmationDialog.style.display = 'none';
        window.location.href = "songList.jsp";
        return false; // Prevent the form from submitting
    }
</script>
</body>
</html>



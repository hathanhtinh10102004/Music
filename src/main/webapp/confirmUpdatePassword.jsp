<%--
  Created by IntelliJ IDEA.
  User: kimanh
  Date: 09/11/2023
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xác nhận cập nhật mật khẩu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            background-color: #4CAF50;
            color: #fff;
            border-radius: 4px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #45a049;
        }

        .cancel-link {
            color: #333;
            text-decoration: none;
            margin-left: 10px;
        }
    </style>
    <script>
        function updatePassword() {
            alert("Cập nhật thành công");
            window.location.href = "editPassWord.jsp";
        }
    </script>
</head>
<body>




<h2>${ConfirmMessage}</h2>
<button class="button" onclick="updatePassword()">Cập nhật</button>
<a class="cancel-link" href="editPassWord.jsp">Hủy</a>
</body>
</html>

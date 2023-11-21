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
    <script>
        function updatePassword() {
            alert("Cập nhật thành công");
            window.location.href = "editPassWord.jsp";
        }
    </script>
</head>
<body>
<h2>${ConfirmMessage}</h2>
<button onclick="updatePassword()">Cập nhật</button>
<a href="editPassWord.jsp">Hủy</a>
</body>
</html>

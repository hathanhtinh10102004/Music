<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duk
  Date: 01/11/2023
  Time: 08:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<form>
    <div>
        <table>
            <tr>
                <th>User ID</th>
                <th>User Name</th>
                <th>User Email</th>
                <th>User Phone</th>
                <th>Action</th>
            </tr>
            <c:forEach var="item" items="${requestScope['userList']}">
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getEmail()}</td>
                    <td>${item.getPhoneNumber()}</td>
                    <td>
                        <a href="/delete?Id=${item.getId()}">Delete</a>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</form>

</body>
</html>

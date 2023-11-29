<%--
  Created by IntelliJ IDEA.
  User: hathanhtinh
  Date: 21/11/2023
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Song</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        #header {
            width: 100%;
            height: 100px;
            background-color: white;
        }

        #content {
            width: 100%;
            height: 85%;
            display: flex;
            /*justify-content: center;*/
            align-items: center;
            flex-direction: column;
        }

        #content table {
            border-collapse: collapse;
            margin: 100px;
        }

        #content table th {
            height: 40px;
            width: 150px;
        }

        footer {
            background-color: darkslategray;
            color: white;
            text-align: center;
            height: 50px;
        }

        #footer {
            width: 100%;
            height: 40px;
        }
        body {
            background-image: url("https://revelogue.com/wp-content/uploads/2022/02/am-nhac-nuoc-ngoai-hinh-anh-1-e1645342333526.jpeg");
            background-size: cover;
        }
        h1 {
            margin: 50px;
        }
    </style>
</head>
<body>
<%--<div id="header"></div>--%>
<div id="content">
    <div>
        <h1>Update Song</h1>
    </div>
    <form action="/admin" method="get">
        <input type="hidden" value="${user.getEmail()}" name="email"/>
        <input type="hidden" value="${user.getPassWord()}" name="password"/>
        <button name="action" value="back" style="border: none"> <- Back</button>
    </form>
    <table border="1">
        <tr>
            <th>Song</th>
            <th>Singer</th>
            <th>Action</th>
        </tr>
        <c:forEach var="list" items="${list}">
            <form action="songList" method="post">
                <tr>
                    <td><input type="text" name="songName" value="${list.songName}"/></td>
                    <td><input type="text" name="singer" value="${list.singer}"/></td>
                    <td>
                        <input type="hidden" value="${user.getEmail()}" name="email"/>
                        <input type="hidden" value="${user.getPassWord()}" name="password"/>
                        <button name="action" value="confirm">Confirm</button>
                    </td>
                    <td><input type="hidden" name="id" value="${list.id}"/></td>
                </tr>
            </form>
        </c:forEach>
    </table>
</div>

<%--<div id="footer">--%>
<%--    <footer> &copy; Web Music.com</footer>--%>
<%--</div>--%>
</body>
</html>






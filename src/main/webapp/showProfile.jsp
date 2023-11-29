<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hathanhtinh
  Date: 22/11/2023
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Song List</title>
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
        }

        #content table {
            border-collapse: collapse;
        }

        #content table th {
            height: 40px;
            width: 300px;
        }

        #content {
            display: flex;
            /*justify-content: center;*/
            align-items: center;
            flex-direction: column;
        }

        #content table {
            /*margin: 20px;*/
        }

        #footer {
            width: 100%;
            height: 40px;
            background: white;
            text-align: center;
        }

        /*footer {*/
        /*    background-color: darkslategray;*/
        /*    color: white;*/
        /*    text-align: center;*/
        /*    height: 50px;*/
        /*}*/

        h1 {
            text-align: center;
            color: #1f1f1f;
            margin: 100px;
        }

        .hit {
            text-align: center;
        }

        body {
            background-image: url("https://cdn.pixabay.com/photo/2017/01/11/10/25/headsets-1971383_640.jpg");
            background-size: cover;
        }

    </style>
</head>
<body>
<%--<div id="header">--%>
<%--</div>--%>

<div id="content">
    <div class="hit">
        <h1>Song Information</h1>
    </div>
    <form action="/admin" method="get">
        <input type="hidden" value="${user.getEmail()}" name="email"/>
        <input type="hidden" value="${user.getPassWord()}" name="password"/>
        <button name="action" value="back" style="border: none"> <- Back</button>
    </form>
    <table border="1">
        <tr style="text-align: center">
            <th>Tên bài hát</th>
            <th>Tên ca sĩ</th>
            <th>Mô tả bài hát</th>
            <th>Lượt xem</th>
            <th>Lời bài hát</th>
            <%--            <th>Ảnh</th>--%>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr style="text-align: center">
                <td>${list.songName}</td>
                <td>${list.singer}</td>
                <td>${list.description}</td>
                <td>${list.listen}</td>
                <td>${list.mp3_file_path}</td>
                <form action="songList" method="post">
                        <%--                    <img width="100px" src="${list.image}">--%>
                    <input type="hidden" name="id" value="${list.id}"/>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>
<%--<div id="footer">--%>
<%--    <footer> &copy; Web Music.com</footer>--%>
<%--</div>--%>
</body>
</html>




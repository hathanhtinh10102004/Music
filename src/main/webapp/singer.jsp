<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kimanh
  Date: 14/11/2023
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Singer</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="https://kit.fontawesome.com/d69fb28507.js" crossorigin="anonymous"></script>
    <style>
        * {
            margin: 0;
            padding: 5px;
            box-sizing: border-box;
        }

        body {
            background-color: #d9d9d9;
            height: 100vh;
            display: flex;
            /*align-items: center;*/
            justify-content: center;
            background-image: url("https://didongviet.vn/dchannel/wp-content/uploads/2022/10/lofi-chill-la-gi-didongviet-4.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }

        .parent {
            position: relative;
        }

        .input::placeholder {
            color: green;
        }

        .parent.active .input {
            width: 200px;
        }

        th {
            border: 1px solid wheat;
            padding: 5px;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
            width: 800px;
        }

        #header {
            height: 80px;
            text-align: center;
            color: white;
        }

        .parent {
            height: 50px;
        }

        .s {
            color: #ffffff;
        }

        .a {
            margin-top: 70px;
        }

        .h {
            margin-top: 30px;
        }
    </style>
</head>
<body>
<form action="singer" method="post">
    <div class="a">
        <div id="header">
            <h1>Name Singer</h1>
            <button name="action" value="back" style="border: none; position: absolute; left: 10px; top: 10px;">
                <a href="Home.jsp" style="text-decoration: none; color: blueviolet;">&lt;- Back</a>
            </button>
        </div>
<%--        <div class="parent">--%>
<%--            <p style="color: red">${message}</p>--%>
<%--            <input class="input" type="type" placeholder="Search..." name="find" id="word" size="30"/>--%>

<%--            <button class="btn" name="action" value="Search">--%>
<%--                <i class="fa-solid fa-magnifying-glass">Search</i>--%>
<%--            </button>--%>
<%--        </div>--%>
        <div class="h">
            <table border="1">
                <tr>
                    <th class="s">Name Singer</th>
                    <th class="s">Name Song</th>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${listSinger}" var="listSinger">
                            <p style="color: white">${listSinger.nameSinger}</p>
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach items="${listSong}" var="listSong">
                            <p style="color: white">${listSong.nameSong}</p>
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</form>
</body>
</html>

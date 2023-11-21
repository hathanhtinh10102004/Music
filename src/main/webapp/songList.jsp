<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: kimanh--%>
<%--  Date: 14/11/2023--%>
<%--  Time: 23:35--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Song List</title>--%>
<%--    <title>Song list</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
<%--    <style>--%>
<%--        header {--%>
<%--            background-color: #ffffff;--%>
<%--            padding: 50px;--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        h1 {--%>
<%--            color: #fff;--%>
<%--        }--%>

<%--        nav ul {--%>
<%--            list-style-type: none;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--        }--%>

<%--        nav ul li {--%>
<%--            display: inline-block;--%>
<%--            margin-right: 10px;--%>
<%--        }--%>

<%--        nav ul li a {--%>
<%--            text-decoration: none;--%>
<%--            color: #fff;--%>
<%--            padding: 5px;--%>
<%--        }--%>

<%--        footer {--%>
<%--            padding: 50px;--%>
<%--            text-align: center;--%>

<%--        }--%>

<%--        p {--%>
<%--            color: #fff;--%>
<%--        }--%>
<%--        body{--%>
<%--            background-color: #212020;--%>
<%--        }--%>
<%--        .container tr th {--%>
<%--            color: white;--%>
<%--        }--%>
<%--        td {--%>
<%--            color: white;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <h1 style="text-align: center">Song list</h1>--%>
<%--<form action="/songList" method="get">--%>
<%--    <div class="container">--%>
<%--        <table class="table table-bordered border-primary">--%>
<%--            <tr>--%>
<%--                <th>Creator</th>--%>
<%--                <th>NameSong</th>--%>
<%--                <th>Listens</th>--%>
<%--                <th>Img</th>--%>
<%--            </tr>--%>
<%--            <c:forEach var="list" items="${lists}">--%>
<%--                <tr>--%>
<%--                    <td>${list.creator}</td>--%>
<%--                    <td>${list.nameSong}</td>--%>
<%--                    <td>${list.listens}</td>--%>
<%--                    <td style="width: 150px"><img src="${list.img}" width="200px"></td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
<%--    </div>--%>

<%--</form>--%>
<%--<footer>--%>
<%--    <h6 style="text-align: center"></h6>--%>
<%--</footer>--%>
<%--</body>--%>
<%--</html>--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kimanh
  Date: 14/11/2023
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Song List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background-color: #212020;
        }

        header {
            background-color: #212020;
            padding: 50px;
            text-align: center;
        }

        h1 {
            color: #fff;
            font-family: "Tibetan Machine Uni", sans-serif;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        nav ul li {
            display: inline-block;
            margin-right: 10px;
        }

        nav ul li a {
            text-decoration: none;
            color: #212020;
            padding: 5px;
        }

        footer {
            padding: 50px;
            text-align: center;
            background-color: #212020;
        }

        .container {
            margin-top: 50px;
        }

        table {
            width: 100%;
            background-color: #212020;
            color: #212020;
            border-collapse: collapse;


        }

        th {
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
            text-align: left;
            padding: 10px;
            border: 1px solid #fff;

        }

        td {
            padding: 10px;
            color: white;
            border: 1px solid #fff;

        }

        img {
            width: 100%;
            max-width: 150px;
            height: auto;
        }

    </style>
</head>
<body>
<header>
    <h1>Song List</h1>
    <a href="create_song.jsp">Add Song</a> <!-- Thêm liên kết để chuyển đến trang add_song.jsp -->
</header>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>Song Name</th>
            <th>Singer</th>
            <th>File MP3</th>
            <th> Image</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.songName}</td>
                <td>${list.singer}</td>
                <td>${list.mp3_file_path}</td>
              <td><img src="${list.image}" ></td>


            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<footer>
    <%--    <h6>Footer content</h6>--%>
</footer>



</body>
</html>
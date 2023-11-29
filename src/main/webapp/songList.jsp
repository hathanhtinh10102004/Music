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
            text-align: center;
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

        .f {
            width: 300px;
            text-align: center;
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

        body {
            background-image: url("https://media.istockphoto.com/id/1076840920/vi/vec-to/n%E1%BB%81n-nh%E1%BA%A1c.jpg?s=612x612&w=0&k=20&c=H-n_Ov3FHuVV8mkZk-UcGr54FdFYRkTiQ2Run37HmDY=");
            background-size: cover;
        }

        h1 {
            text-align: center;
            margin: 50px;
        }

        .a {
            display: flex;
            justify-content: center;
            color: #1f1f1f;
        }

    </style>
</head>
<body>
<h1>Song List</h1>
<div  class="a" >
    <a href="create_song.jsp?&email=${user.getEmail()}&password=${user.getPassWord()}">Add Song</a> <!-- Thêm liên kết để chuyển đến trang add_song.jsp -->
</div>
<div class="container">
    <table class="table">
        <div style="margin-top: 40px">
            <form action="/admin" method="get">
                <input type="hidden" value="${user.getEmail()}" name="email"/>
                <input type="hidden" value="${user.getPassWord()}" name="password"/>
                <button name="action" value="back" style="border: none"> <- Back</button>
            </form>
        </div>
        <tr>
            <th>Song Name</th>
            <th>Singer</th>
            <th>File MP3</th>
            <th> Image</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach var="list" items="${list}">
            <tr>
                <form action="songList" method="post">
                    <td style="text-align: center">${list.songName}</td>
                    <td style="text-align: center">${list.singer}</td>
                    <td style="text-align: center">${list.mp3_file_path}</td>
                    <td style="text-align: center" width="100px"><img src="${list.image}"></td>
                    <td class="f">
                        <button name="action" value="update">Update</button>

                        <button name="action" value="profile">Profile</button>

                        <input type="hidden" value="${user.getEmail()}" name="email"/>
                        <input type="hidden" value="${user.getPassWord()}" name="password"/>

                        <input type="hidden" name="id" value="${list.id}"/>
                        <div id="confirmationDialog" class="confirmation-dialog">
                            <p style="color: red">Do you want to update?</p>
                            <button name="action" value="delete" onclick="confirmUpdate()">OK</button>
                            <button onclick="cancelUpdate()">Cancel</button>
                        </div>
                </form>
                <button onclick="showConfirmation()">Delete</button>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${not empty update}">
            <script>
                alert("${update}")
            </script>
        </c:if>
        </tbody>
    </table>
</div>
<%--<form action="songList" method="post">--%>

<%--</form>--%>
<%--<footer>--%>
<%--    <h6>Footer content</h6>--%>
<%--</footer>--%>
<script>
    function home() {
        window.location.href = "Home.jsp";
    }

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


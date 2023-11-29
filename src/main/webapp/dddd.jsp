<%--
  Created by IntelliJ IDEA.
  User: hathanhtinh
  Date: 28/11/2023
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-top: 0;
        }

        .profile-pic {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            margin: 0 auto 20px;
            display: block;
        }

        .song-info {
            text-align: center;
            margin-bottom: 20px;
        }

        .song-info h2 {
            margin: 0;
            color: #333;
        }

        .song-info p {
            margin: 0;
            color: #777;
        }

        .song-description {
            margin-bottom: 20px;
            color: #555;
        }

        .song-description p {
            margin: 0;
        }

        .song-actions {
            text-align: center;
        }

        .song-actions button {
            padding: 10px 20px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .song-actions button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Profile Bài Hát</h1>
    <img class="profile-pic" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKHLPhbEapOaV6KZC9Knkjn-8PbzjB5cr4WA6cDK6oxWd3vXkkMyiQklo7L4ETrgVrpGg&usqp=CAU" alt="Hình ảnh">
    <div class="song-info">
        <h2>Tên Bài Hát</h2>
        <p>Tác giả: Tên Tác Giả</p>
    </div>
    <div class="song-description">
        <p>Mô tả bài hát: Đây là một bài hát tuyệt vời với những giai điệu sôi động và lời ca cảm động.</p>
    </div>
    <div class="song-actions">
        <button>Nghe Bài Hát</button>
    </div>
</div>
</body>
</html>

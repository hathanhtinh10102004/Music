<%@ page import="Model.Playlist" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: duk
  Date: 07/11/2023
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Playlist</title>
    <style>
        .navbar {
            overflow: hidden;
            background-color: #333;
            position: fixed;
            top: 0;
            width: 100%;
        }

        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .slider {
            padding: 16px;
            margin-top: 70px;
            display: block;
        }

        .playlist-card {
            flex: 0 0 auto;
            width: 300px;
            /*margin-right: 10px;*/
        }

        .playlist-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }
        .navbar {
            wild: 95%;
            height: auto;
            border:1px solid #36e2ec;
            margin: auto;
        }
        .slider .h4 {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
    </style>
</head>
<body>
<div class="navbar">
    <a href="#home">Home</a>
</div>
<div class="slider" style="display: grid; grid-template-colum: repeat(4,1fr);grid-gap:20px;">
    <div class="h4">Playlist Top Like</div>
    <%
        List<Playlist> playlists = (List<Playlist>) request.getAttribute("playlists");
        for (Playlist playlist : playlists) {
    %>
    <div class="playlist-card">
        <img src="<%= playlist.getImageUrl() %>" alt="Playlist Image">
        <div>
            Creator: <%= playlist.getCreatorName() %>
        </div>
    </div>
    <% } %>
</div>
</div>
</body>
</html>
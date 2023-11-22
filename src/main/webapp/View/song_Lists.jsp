<%@ page import="Model.Song" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: duk
  Date: 21/11/2023
  Time: 08:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Song</title>
    <style>
        .slider {
            display: flex;
            overflow-x: auto;
            scroll-snap-type: x mandatory;
            scroll-behavior: smooth;
            scroll-padding: 10px;
            border:1px solid #36e2ec;
            width:auto ;
            height: 290px;
            position: relative;
            z-index: 1;
        }

        .playlist-card {
            flex: 0 0 auto;
            width: 300px;
            border:1px solid #000;
            margin: auto;
            border-radius: 10px;
            position: relative;
            z-index: 2;
        }
        .slider .playlist-card .creatorName {
            display: flex;
            align-items: center;
            justify-content: center;
            text-align:center;
        }
        .slider .playlist-card .likeCount {
            display: flex;
            align-items: center;
            justify-content: center;
            text-align:center;
        }

        .playlist-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }
        .slider .h4 {
            display: flex;
            align-items: center;
            justify-content: space-between;
            text-align:left;
            top: 0;
            left: 0;
        }
    </style>
</head>
<body>

<div class="slider" >
    <div class="h4"> Song top like</div>
    <%
        List<Song> songs = (List<Song>) request.getAttribute("songs");
        for (Song song : songs) {
    %>
    <div class="playlist-card">
        <img src="<%= song.getImageUrl() %>" alt="Song Image">
        <div class="creatorName">
            Singer: <%= song.getCreatorName() %>
        </div>
        <div class="likeCount">
            Like: <%= song.getLikeCount() %>
        </div>

    </div>
    <% } %>
</div>
</body>
</html>

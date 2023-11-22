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
        body{
            background-color: #f2f2f2;
            background-size: cover;
            background-image: url("https://www.google.com/url?sa=i&url=https%3A%2F%2Fpngtree.com%2Ffreebackground%2Fblue-musical-notes-background_1986629.html&psig=AOvVaw05H6x2gPoMf65EFMm3yuFH&ust=1700712761097000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCLj87vHe1oIDFQAAAAAdAAAAABAJ");
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
            margin-top: 200px;
            display: block;
            border:1px solid #36e2ec;
            background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdpWg9aGJo4l7wZYom73mV3HZmhlgI0taVYY_GyOtVLg&s");
            background-size: cover;
            margin: auto;
            border-radius: 10px;
            width: 300px;
            height: auto;
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
        .name{
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
        .navbar {
            width: 95%;
            height: auto;
            border:1px solid #36e2ec;
            margin: auto;
        }
        .slider .h2 {
            font-size:30px;
            font-family:Blenda;
            font-weight: bold;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align:center;
        }
    </style>
</head>
<body>

    <div class="slider" style="display: grid; grid-template-colum: repeat(4,2fr);grid-gap:20px;">
        <div class="h2">Playlist top like</div>
        <%
            List<Playlist> playlists = (List<Playlist>) request.getAttribute("playlists");
            for (Playlist playlist : playlists) {
        %>
        <div class="playlist-card">
            <img src="<%= playlist.getImageUrl() %>" alt="Playlist Image">
          <div class="name">
            Creator: <%= playlist.getCreatorName() %>
          </div>
            <div class="likeCount">
                Like: <%= playlist.getLikeCount() %>
            </div>
        </div>
        <% } %>
    </div>


</body>
</html>
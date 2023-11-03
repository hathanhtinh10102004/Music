<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    #wrapper {
        width: auto;
        margin: auto;
    }

    #header {
        width: 1848px;
        height: 100px;
        background-color: #1f1f1f;
    }


    #left {
        width: 20%;
        height: 704px;
        background-color: #171b25;
        float: left;
    }

    #content {
        width: 60%;
        height: 704px;
        background-color: #030715;
        float: left;
    }

    #right {
        width: 20%;
        height: 704px;
        background-color: #030715;
        float: left;
    }

    #footer {
        width: 1848px;
        height: 70px;
        background-color: #18191e;
        clear: both;
    }

    #zing-logo {
        position: absolute;
        left: 25px;
        width: 200px;
        height: 88px;
    }

    span {
        font-family: "Tibetan Machine Uni", sans-serif;
        font-size: 25px;
        float: left;
        color: #fff;
    }

    .drop-ttn {
        width: 70px;
        font-size: 28px;
        background-image: none;
        background-color: transparent;
    }

    #menu {
        width: 1848px;
        height: 70px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #333;
        color: #fff;
        padding: 0 30px;
    }

    #menu h2 {
        text-align: left;
        margin: 0;
    }

    .search-container {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .search-input {
        border: gainsboro;
        margin-top: 30px;
        padding: 5px;
        width: 300px;
        -webkit-border-radius: 15px;
        font-size: 18px;
        background-image: url("tải xuống.png");
        background-repeat: no-repeat;
        background-position: 10px center;
        background-size: 20px 20px;
        padding-left: 40px;
    }

    .search-button {
        border: gainsboro;
        margin-top: 30px;
        -webkit-border-radius: 15px;
        margin-left: 10px;
        font-size: 18px;
        padding: 5px 10px;
    }
    .hover-listPlay ul {
        list-style-type: disc;
        color: #fff;
        padding: 0;
    }

    .hover-listPlay ul li {
        padding: 20px;
    }

    .hover-listPlay ul li:hover {
        color: deepskyblue;
    }
    .nav {
        list-style: none;
    }

    .nav > li{
        position: relative;

    }
    #sub-nav {
        display: none;
        list-style: none;
        position: absolute;
        top: 50px;
        left: -100px;
    }
    #sub-nav button {
        padding: 10px;
        border: none;
        background-color: #c3c3cb;
        color: #020202;
        width: 100px;
    }
    #sub-nav button:hover {
        background-color: #e2e2e3;
        color: black;
    }
</style>
<head>
    <title>Zing MP3</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div class="header-conter">
            <img src="Screenshot_from_2023-11-01_09-07-39-removebg-preview (1).png" id="zing-logo">
        </div>
        <div class="search-container">
            <input type="text" id="search-input" class="search-input" placeholder="Nhập từ khóa tìm kiếm...">
            <button type="button" id="search-button" class="search-button">Tìm kiếm</button>
        </div>
    </div>
    <div id="menu">
        <span>PlayList</span>
        <ul class="nav">
            <li onclick="showSubNav()"><a class="drop-ttn"><i class="fa fa-bars" style="color: #fff"></i></a>
                <ul id="sub-nav">
                    <c:forEach var="list" items="${list}">
                        <li>
                            <form action="/user?id=${list.id}" method="post">
                                <button  name="action" value="formEdit">Update Profile</button>
                            </form>
                        </li>
                        <li>
                            <form action="/editPassWord.jsp" >
                                <button name="action" value="fromChangePassword">Change Password</button>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </li>

        </ul>




    </div>
    <div id="left">
        <div class="hover-listPlay">
            <ul>
                <li class="menu-myPlaylist" style="color: #fff"><a href="login.jsp" style="color: #fff">My Playlist</a>
                </li>
                <li class="menu-last" style="color: #fff">User List </li>
                <li class="menu-recommended" style="color: #fff">Admin List</li>
            </ul>
        </div>
    </div>

    <div id="content"></div>
    <div id="right"></div>
    <div id="footer"></div>
    <script>
        function showSubNav(){
            let subNav = document.getElementById("sub-nav");
            console.log(subNav)
            let currentDisplay = subNav.style.display
            if (currentDisplay === "none"){
                subNav.style.display = "inline-block"
            } else {
                subNav.style.display = "none"
            }
        }
    </script>
</div>
</body>
</html>




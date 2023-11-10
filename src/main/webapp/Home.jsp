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
        width: 30%;
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
        width: 10%;
        height: 704px;
        background-color: #030715;
        float: left;
    }

    #footer {
        width: 1848px;
        height: 70px;
        background-color: #18191e;
        clear: both;
        padding: 15px
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

    .nav > li {
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

    .left-menu-music {
        display: flex;
        align-items: center;
        margin-top: 40px;
        margin-left: 10px;
    }

    .songList {
        position: relative;
        list-style-type: none;
        font-size: 18px;
    }

    .songItem {
        display: flex;
        align-items: center;
        gap: 10px;
    }
    .bi-play-circle-fill {
        margin-top: 1px;
    }

    .songItem span {
        font-size: 14px;
        color: #4c5206;
        margin-right: 10px;
    }

    .thumbnail {
        width: 40px;
        height: 40px;
        object-fit: cover;
    }
    h5 {
        margin-left: 15px;
        margin-top: -20px;
    }
    .sub-title {
        position: absolute;
    }
    .bi-play-circle-fill::before {
        content: "\f4f2";
        margin-left: 20px;
        margin-top: 5px;
        font-size: 13px;
    }
    .playlist-text {
        font-family: Arial, sans-serif;
        font-size: 24px;
        color: #fff;
        text-transform: uppercase;
        letter-spacing: 2px;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8);
        animation: blink 1s infinite;
    }

    @keyframes blink {
        0% {
            opacity: 1;
        }
        50% {
            opacity: 0.5;
        }
        100% {
            opacity: 1;
        }
    }
    .songItem:hover .thumbnail,
    .songItem:active .thumbnail {
        animation: blink 1s infinite;
    }

    .songItem:hover h5,
    .songItem:active h5 {
        animation: blink 1s infinite;
    }

    @keyframes blink {
        0% {
            opacity: 1;
        }
        50% {
            opacity: 0.5;
        }
        100% {
            opacity: 1;
        }
    }
    .master-play {
        display: flex;
        align-items: center;
        padding: 0px 20px;
    }
    .master-play .wave {
      width: 40px;
        height: 40px;
        /*border: 1px solid #fff;*/
        padding-bottom:5px ;
        display: flex;
        align-items: flex-end;
        margin-right: 10px;
    }
    .master-play .wave .wave1{
        width: 4px;
        height: 10px;
       margin-right: 3px;
        border-radius: 10px 10px 0px 0px ;
        background: #3a7ae1;
        animation: unset ;
    }
    .master-play .wave .wave1:nth-child(2) {
        height: 13px;
        /*animation-delay: .4s;*/
    }
    .master-play .wave .wave1:nth-child(3) {
        height: 8px;
        /*animation-delay: .8s;*/
    }
    /* javascript class wave */
    .master-play .wave .action2 .wave1{
        animation: wave .5s linear infinite ;
    }
    .master-play .action2 .wave1:nth-child(2) {
        animation-delay: .4s;
    }
    .master-play .action2 .wave1:nth-child(3) {
        animation-delay: .8s;
    }

    @keyframes wave {
        0%{
            height: 10px;
        }
        50%{
            height: 15px;
        }
        100%{
            height: 10px;
        }
    }

    .master-play img {
        width: 35px;
        height: 35px;
    }
    .master-play h5 {
        width: 150px;
        font-size: 15px;
        margin-left: 15px;
        color: #fff;
        line-height: 15px;
    }
    .master-play h5 .sub-title {
        font-size: 11px;
        color: #4c5262;
    }
    .icon {
        font-size: 25px;
        color: #ffffff;
        margin-top: -12px;
        margin-left: 20px;
    }
    .icon .bi {
        cursor: pointer;
         outline: none;
    }
     .icon .bi:nth-child(2) {
        border: 1px solid rgb(105,105,170,1);
         border-radius:50px;
         padding: 1px 3px 0px 6px;
         margin: 0px 5px;
         transition: .3s linear;
    }
     .master-play span {
         color: #fff;
         width: 32px;
         font-size: 11px;
         font-weight: 400;
     }
     #currenStart {
        margin: 0px 0px 0px 20px;
    }
    .master-play .bar {
        position: relative;
        width: 43%;
        height: 2px;
        background: rgb(105,105,170,.1);
        margin: 0px 15px 0px 10px ;
    }
    .master-play .bar .bar2{
        position: absolute;
        background: #36e2ec;
        width: 0%;
        height: 100%;
        top: 0;
    }
    .master-play .bar .dot {
       position: absolute;
        width: 5px;
        height: 5px;
        background: #36e2ec;
        border-radius: 50%;
        left: 0%;
        top: -1px;
        transition: 1s linear;
    }
    .master-play .bar .dot:before {
        content: '';
        position: absolute;
        width: 15px;
        height: 15px;
        border: 1px solid #36e2ec;
        border-radius: 50px;
        top: -1px;
        transition: 1s linear;
        box-shadow: inset 0px 0px 3px #36e2ec;
        margin-left: -6px;
        margin-top: -5px;
    }
    .master-play .bar input {
        position: absolute;
        width: 100%;
        top: -6px;
        left: 0;
        cursor: pointer;
        z-index: 99999999;
        transition: 3s linear;
        opacity: 0;
    }



    .master-play .vol {
        position: relative;
        width: 100px;
        height: 2px;
        margin-left: 50px;
        background: rgb(105,105,170,.1);
    }
    .master-play .vol .bi {
        position: absolute;
        color: #fff;
        font-size: 25px;
        top: -17px;
        left: -30px;
    }
    .master-play .vol input {
        position: absolute;
        width: 130px;
        top: -9px;
        left: 0;
        cursor: pointer;
        z-index: 9999999;
    }
    .master-play .vol .vol-bar{
        position: absolute;
        background: #36e2ec;
        width: 0%;
        height: 100%;
        top: 0;
    }
    .master-play .vol .dot {
        position: absolute;
        width: 5px;
        height: 5px;
        border-radius: 50%;
        left: 0%;
        top: -1px;
        transition: 1s linear;
    }
    .master-play .bar .dot:before {
        content: '';
        position: absolute;
        width: 15px;
        height: 15px;
        border: 1px solid #36e2ec;
        border-radius: 50px;
        top: -1px;
        transition: 1s linear;
        box-shadow: inset 0px 0px 3px #36e2ec;
        margin-left: -6px;
        margin-top: -5px;
    }
    .song_side {
        width: 1000px;
        height: 70px;
    }
    .song_side nav {
        width: 100%;
        height: 70px;
        margin: auto;
        /*border: 1px solid #fff;*/
        display: flex;
        align-items: center;
        justify-content: space-between;
        margin-left: 100px;
    }
    .song_side nav ul li {
        margin-right: 80px;
    }

    .song_side nav ul li:last-child {
        margin-right: 0;
    }
    .song_side nav ul {
        display: flex;
    }
    .song_side nav ul {
        position: relative;
        list-style-type: none;
        font-size: 17px;
        color: #818691;
        margin-right: 25px ;
        cursor: pointer;
        transition: .3s linear;
    }
    .song_side nav ul li:hover {
        color: #fff;
    }
    .song_side nav ul li span {
        position: absolute;
        width: 100%;
        height: 2.5px;
        background:#36e2ec ;
        bottom: -5px;
        left: 0;
        border-radius: 20px;
    }
    p {
        color: #727680;
        margin-left: 50px;
        margin-top: 20px;
    }
    h1 {
        font-size: 40px;
        margin-left: 50px;
        margin-top: 30px;
        font-weight: 500;
    }
    .buttons {
        margin-left: 50px;
    }
    #content .buttons {
        margin-left: 50px;
        font-size: 20px;
        padding-top: 20px;
    }
    #content .flex-content {
        margin-left: 50px;
        font-size: 20px;
        padding-top: 20px;
    }
    #content .buttons {
        margin-top: 15px;
    }
    #content .buttons button {
       width: 130px;
        height: 30px;
        border: 2px solid #36e2ec;
        outline: none;
        border-radius: 20px;
        background: #2ca8af;
        color: #fff;
        cursor: pointer;
        transition: .3s linear;
    }
    #content .buttons button:hover {
        border: 2px solid #36e2ec ;
        background: none;
        color: #36e2ec;
    }

    /*menu top*/

    {
        margin: 0;
        padding: 0;
        font-family: 'Poppins', sans-serif;
    }
    .action{
        position: fixed;
        top: 20px;
        right: 30px;
    }
    .action .profile{
        position: relative;
        width: 60px;
        height: 60px;
        border-radius: 50px;
        overflow: hidden;
        cursor: pointer;
    }
    .action .profile img{
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        object-fit: cover;
    }
    .action .menu{
        position: absolute;
        top: 80px;
        right: -10px;
        padding: 10px 20px;
        background: #fff;
        width: 150px;
        border-radius: 15px;
        visibility: hidden;
        opacity: 0;
    }
    .action .menu::before{
        content: '';
        position: absolute;
        top: -5px;
        right: 28px;
        width: 20px;
        height: 20px;
        background: #fff;
        transform: rotate(45deg);
    }
    .action .menu ul li{
        list-style: none;
        padding: 10px 0;
        border-top: 1px solid rgba(0,0,0,0.05);
        align-items: center;
        display: flex;
        /*justify-content: center;*/
    }
    .action .menu.active{
        visibility: visible;
        opacity: 1;
    }


</style>
<head>
    <title>Zing MP3</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <script src="https://kit.fontawesome.com/ea1336070b.js" crossorigin="anonymous"></script>
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
            <span class="playlist-text">PlayList</span>
            <div class="song_side">
                <nav>
                    <ul>
                        <li>DISCOVER </li>
                        <li>MY LIBRARY </li>
                        <li>RADIO </li>
                    </ul>
                </nav>
                <div class="search"></div>
            </div>
        </form>
        <ul class="nav">
            <li onclick="showSubNav()"><a class="drop-ttn"><i class="fa-solid fa-bars"></i></a>
                <ul id="sub-nav">
                    <c:forEach var="list" items="${list}">
                        <li>
                            <form action="/user?id=${list.id}" method="post">
                                <button name="action" value="formEdit">Update Profile</button>
                            </form>
                        </li>
                        <li>
                            <form action="/editPassWord.jsp">
                                <button name="action" value="fromChangePassword">Change Password</button>
                            </form>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </ul>
        <div class="action">
            <div class="profile" onclick="menuToggle();">
                <img src="data:image/png;base64,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">
            </div>
            <div class="menu">
                <ul>
                    <li><a href="#">Name</a></li>
                    <li><a href="#">Account</a></li>
                    <li><a href="#">account management</a></li>
                    <li><a href="#">logout</a></li>
                </ul>
            </div>
        </div>
        <script>
            function menuToggle() {
                const toggleMenu = document.querySelector('.menu');
                toggleMenu.classList.toggle('active')
            }
        </script>
    </div>

    <div id="left">
        <div class="hover-listPlay">
            <ul>
                <li class="menu-myPlaylist" style="color: #fff"><a href="login.jsp" style="color: #fff" >My Playlist</a>
                </li>
                <li class="menu-last" style="color: #fff">User</li>
                <c:forEach var="list" items="${list}">
                    <li class="menu-recommended" style="color: #fff">
                        <a href="admin?action=showUser&email=${list.email}&password=${list.passWord}" style="color: white ">Admin</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="left-menu-music">
            <ul class="songList">
                <li class="songItem">
                    <span>01</span>
                    <img class="thumbnail" src="https://avatar-ex-swe.nixcdn.com/song/2023/05/26/3/1/f/c/1685115005420_640.jpg" alt="img-nmntlc" >
                    <h5 style="color: white">
                        Ngày Mai Người Ta Lấy Chồng
                        <div class="sub-title" style="color: #4c5262">Thành Đạt <br/></div>
                    </h5>
                    <i class="bi playListPlay bi-play-circle-fill" style="color: white" id="1"></i>

                </li><br/><br/>

                <li class="songItem">
                    <span>02</span>
                    <img class="thumbnail" src="https://photo-resize-zmp3.zmdcdn.me/w240_r1x1_jpeg/cover/9/8/6/c/986ccfe2a965e11b4c967745a0fefe96.jpg" alt="img-nmntlc" >
                    <h5 style="color: white">
                       Ngày Mai Em Đi Mất
                        <div class="sub-title" style="color: #4c5262"> Đạt G <br/></div>
                    </h5>
                    <i class="bi playListPlay bi-play-circle-fill" style="color: white" id="2"></i>

                </li><br/><br/>

                <li class="songItem">
                    <span>03</span>
                    <img class="thumbnail" src="https://photo-resize-zmp3.zmdcdn.me/w600_r1x1_jpeg/cover/2/9/b/f/29bf1c15a2aeacf72a2fa1e84d92f3e9.jpg" alt="img-nmntlc" >
                    <h5 style="color: white">
                        Nếu Ngày Ấy
                        <div class="sub-title" style="color: #4c5262"> Soobin <br/></div>
                    </h5>
                    <i class="bi playListPlay bi-play-circle-fill" style="color: white" id="3"></i>

                </li><br/><br/>

                <li class="songItem">
                    <span>04</span>
                    <img class="thumbnail" src="https://photo-resize-zmp3.zmdcdn.me/w600_r1x1_jpeg/cover/b/f/0/1/bf0182328238f2a252496a63e51f1f74.jpg" alt="img-nmntlc" >
                    <h5 style="color: white">
                        Cắt Đôi Nỗi Sầu
                        <div class="sub-title" style="color: #4c5262">Tăng Duy Tân <br/></div>
                    </h5>
                    <i class="bi playListPlay bi-play-circle-fill" style="color: white" id="4"></i>
                </li><br/><br/>

                <li class="songItem">
                    <span>05</span>
                    <img class="thumbnail" src="https://lyricvn.com/wp-content/uploads/2022/03/d03338f37bcf00ce8efd35b4023703ad.jpg" alt="img-nmntlc" >
                    <h5 style="color: white">
                        Tình Ta Hai Ngã
                        <div class="sub-title" style="color: #4c5262"> Aki Khoa <br/></div>
                    </h5>
                    <i class="bi playListPlay bi-play-circle-fill" style="color: white" id="5"></i>
                </li><br/><br/>

                <li class="songItem">
                    <span>06</span>
                    <img class="thumbnail" src="https://lyricvn.com/wp-content/uploads/2020/09/afd05622ac31a6f51317b137bef722ec.jpg" alt="img-nmntlc" >
                    <h5 style="color: white">
                        Vở Kịch Của Em
                        <div class="sub-title" style="color: #4c5262"> Hồ Phong An <br/></div>
                    </h5>
                    <i class="bi playListPlay bi-play-circle-fill" style="color: white" id="6"></i>
                </li><br/><br/>
            </ul>
        </div>
    </div>

    <div id="content">
        <div class="flex-content">
            <h1 style="color: white">My Music</h1>
            <p>
                Music is your inspiration, enjoy and feel the wonderful moments
            </p>
            <div class="buttons">
                <button>PLAY</button>
                <button>FOLLOW</button>
            </div>
        </div>

    </div>

    <div id="right"></div>

    <div id="footer">
        <div class="master-play">
            <div class="wave">
                <div class="wave1"></div>
                <div class="wave1"></div>
                <div class="wave1"></div>
            </div>
            <img src="data:image/jpeg;base64,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" alt="img-nmntlc">
            <h5 style="color: white">
                Ngày Mai Em Đi Mất  <br/>
                <div class="sub-title" style="color: #4c5262"> Đạt G <br/></div>
            </h5>
            <div class="icon">
                <i class="bi bi-skip-start-fill"></i>
                <i class="bi bi-play-fill"></i>
                <i class="bi bi-skip-end-fill"></i>
            </div>
            <span id="currenStart"> 0:00</span>
            <div class="bar">
                <input type="range" id="seek" min="0" value="0" max="100">
                <div class="bar2" id="bar2"></div>
                <div class="dot"></div>
            </div>
            <span id="currenEnf"> 0:00</span>

            <div class="vol">
                <i class="bi bi-volume-down-fill"></i>
                <input type="range" id="vol" min="0" value="30" max="100">
                <div class="vol-bar"></div>
                <div class="dot" id="vol-dot"></div>
            </div>
        </div>
    </div>
    <script>
        function showSubNav() {
            let subNav = document.getElementById("sub-nav");
            console.log(subNav)
            let currentDisplay = subNav.style.display
            if (currentDisplay === "none") {
                subNav.style.display = "inline-block"
            } else {
                subNav.style.display = "none"
            }
        }
    </script>
</div>
</body>
</html>





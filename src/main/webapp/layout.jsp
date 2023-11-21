<%--
  Created by IntelliJ IDEA.
  User: hathanhtinh
  Date: 10/11/2023
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number Singer</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link href="./style.css" rel="stylesheet"/>--%>
    <style>
        #header{
            background: yellow;
            height: 100px;
        }
        #menu{
            background: grey;
            height: 30px;
        }
        #main_content{
            background: pink;
        }
        #footer{
            background: red;
            height: 150px;
        }

        #left_sidebar{
            float:left;
            width: 300px;
            height: 400px;
            background: blue;
        }

        #right_sidebar{
            float:right;
            width: 300px;
            height: 400px;
            background: orange;
        }

        #content{
            margin-left: 300px;
            margin-right: 300px;
            height: 300px;
            background: #fff
        }
    </style>
</head>
<body>
<div id="main_wrapper">
    <div id="header">

    </div>
    <div id="menu">
        Menu
    </div>
    <div id="main_content">
        <div id="left_sidebar">
            Left sidebar
        </div>
        <div id="right_sidebar">
            Right sidebar
        </div>
        <div id="content">
            Main Content
        </div>
        <div style="clear: both"></div>
    </div>
    <div id="footer">
        Footer
    </div>
</div>
</body>
</html>





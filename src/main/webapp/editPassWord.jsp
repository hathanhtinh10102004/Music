<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <style>
        body {
            background-image: url("https://w0.peakpx.com/wallpaper/982/58/HD-wallpaper-microphone-ultra-music-dark-black-professional-studio-microphone-record-instrument-songs-voice.jpg");
        }
        .container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin: 180px auto;
        }

        .container h2 {
            text-align: center;
            font-family: Arial, sans-serif;
            color: white;
            margin-top: 50px;
        }

        .container label {
            display: block;
            margin-bottom: 10px;
        }

        .container input[type="text"],
        .container input[type="password"] {
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .container .message {
            margin-top: 10px;
            color: red;
            text-align: center;

        }
        h2 {
            font-family: Arial, sans-serif;
            color: white;
        }
        .container {
            position: relative;
        }

        .back-button {
            position: absolute;
            top: -40px;
            left: 10px;
            border: none;
            background-color: transparent;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        .change-password h2 {
            margin-top: 50px;
        }
    </style>
</head>
<body>
     <form action="Home.jsp" method="post">
         <button name="action" value="back" style="border: none" > <- Back </button>
    </form>
    <div class="change-password">
        <h2>Change Password</h2>
        <div class="container">
            <form action="editPassWord?action=updatePasswords" method="post">
                <input type="hidden" name="id" value="${id}">
                <h1 style="color:#ffffff;">${id}</h1>
                <label for="oldpassword">Current Password:</label>
                <input type="password" id="oldpassword" name="oldpassword" required>
                <label for="newpassword">New Password:</label>
                <input type="password" id="newpassword" name="newpassword" required>
                <label for="conpassword">Confirm Password:</label>
                <input type="password" id="conpassword" name="conpassword" required>
                <input type="submit" value="Change Password">
                <p class="message">

                    ${message}
                </p>
            </form>
        </div>

    </div>
</body>
</html>